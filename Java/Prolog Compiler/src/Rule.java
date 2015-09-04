
public class Rule {

    public static void main(String[] args) {
        Rule r = new Rule(Trs.toTerm("plus(s(X), Y)"), Trs.toTerm("s(plus(X, Y))"));
        Term t = Trs.toTerm("plus(s(o), s(s(o)))");
        Trs.assertToStringEquals(
                "plus(s(o), s(s(o))) should be rewritten to s(plus(o, s(s(o)))).",
                "s(plus(o, s(s(o))))",
                r.rewrite(t));
        r = new Rule(Trs.toTerm("plus(o, Y)"), Trs.toTerm("Y"));
        t = Trs.toTerm("s(plus(o, s(s(o))))");
        Trs.assertToStringEquals(
                "s(plus(o, s(s(o)))) should be rewritten to s(s(s(o))).",
                "s(s(s(o)))",
                r.rewrite(t));
        /*
         *  Usually, rules where the lhs is a variable are not allowed in term rewriting,
         *  but we allow them for the sake of simplicity.
         */
        r = new Rule(Trs.toTerm("X"), Trs.toTerm("f"));
        Trs.assertToStringEquals(
                "A rule with a variable on the left hand side should reduce everything.",
                "s(plus(f, s(s(o))))",
                r.rewrite(t));
        r = new Rule(Trs.toTerm("f(X, X)"), Trs.toTerm("f(X, f(X, X))"));
        Trs.assertToStringEquals(
                "If the rule is not applicable, null should be returned.",
                null,
                r.rewrite(t));
        t = Trs.toTerm("f(f(o, o), f(o, o))");
        Trs.assertToStringEquals(
                "The rule should be applied at the leftmost innermost position.",
                "f(f(o, f(o, o)), f(o, o))",
                r.rewrite(t));
    }

    /**
     * the left hand side of this rule
     */
    private final Term lhs;
    /**
     * the right hand side of this rule
     */
    private final Term rhs;

    public Rule(Term lhs, Term rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public Term getLhs() {
        return lhs;
    }

    public Term getRhs() {
        return rhs;
    }

   public Term rewrite(Term t){
       if(t instanceof FunApp){
           FunApp res = rewriteArgs((FunApp) t);
           if(res != null){
               return res;
           }
       }
       Substitution sigma = Substitution.match(lhs, t);
       if(sigma != null){
           return sigma.apply(rhs);
       }
       return null;
   }
   
   private FunApp rewriteArgs(FunApp t){
       Term[] args = t.getArgs();
       for(int i = 0; i < args.length;i++){
           Term arg = args[i];
           Term newArg = rewrite(arg);
           if(newArg != null){
               return t.replaceArg(i, newArg);
           }
       }
       return null;
   }

    public String toString() {
        return lhs.toString() + " -> " + rhs;
    }
}
