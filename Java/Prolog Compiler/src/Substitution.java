
public class Substitution {

    /**
     * The empty substitution. Since substitutions are immutable, it suffices to
     * have it once.
     */
    public static final Substitution EMPTY = new Substitution(null, null, null);

    public static void main(String[] args) {
        Variable x = new Variable("X");
        Variable y = new Variable("Y");
        Variable z = new Variable("Z");
        Term c = new FunApp(new Symbol("c"));
        Term f = new FunApp(new Symbol("f"), new Term[]{x, y});
        Term g = new FunApp(new Symbol("g"), new Term[]{f, x, y, c});
        Substitution sigma = new Substitution(x, c);
        Substitution theta = new Substitution(y, x, sigma);
        Substitution rho = new Substitution(z, g, theta);
        Trs.assertToStringEquals(
                "sigma.apply(X) with sigma={X/c} should be c",
                "c",
                sigma.apply(x));
        Trs.assertToStringEquals(
                "sigma.apply(Y) should be Y",
                "Y",
                sigma.apply(y));
        Trs.assertToStringEquals(
                "sigma.apply(c) should be c",
                "c",
                sigma.apply(c));
        Trs.assertToStringEquals(
                "theta.apply(g(f(X, Y), X, Y, c)) with theta={Y/X, X/c} should be g(f(c, X), c, X, c)",
                "g(f(c, X), c, X, c)",
                theta.apply(g));
        Trs.assertToStringEquals(
                "rho.apply(g(f(X, Y), X, Y, c)) with rho={Z/g, Y/X, X/c} should be theta.apply(g(f(X, Y), X, Y, c))",
                theta.apply(g),
                rho.apply(g));
        Trs.assertToStringEquals(
                "theta.apply(theta.apply(g(f(X, Y), X, Y, c))) should be g(f(c, c), c, c, c)",
                "g(f(c, c), c, c, c)",
                theta.apply(theta.apply(g)));
       // Trs.assertToStringEquals(
         //       "EMPTY.apply(g(f(X, Y), X, Y, c))) should be g(f(X, Y), X, Y, c))",
           //     "g(f(X, Y), X, Y, c)",
               // EMPTY.apply(g));
    }

    /**
     * @param s a term
     * @param t another term
     * @return a substitution \sigma such that s\sigma=t or null, if such a
     * substitution does not exist
     */
    public static Substitution match(Term s, Term t) {
        if (s instanceof Variable) {
            return new Substitution((Variable) s, t);
        } else if (t instanceof Variable) {
            return null;
        } else {
            return match((FunApp) s, (FunApp) t);
        }
    }

    /**
     * @see Substitution#match(Term, FunApp)
     */
    private static Substitution match(FunApp s, FunApp t) {
        int arity = s.getArgs().length;
        Term[] tArgs = t.getArgs();
        if (s.getSymbol().isEqual(t.getSymbol()) && tArgs.length == arity) {
            FunApp curS = s;
            Substitution res = Substitution.EMPTY;
            for (int i = 0; i < arity; i++) {
                Substitution sigma = match(curS.getArgs()[i], tArgs[i]);
                if (sigma == null) {
                    return null;
                }
                curS = sigma.apply(curS);
                res = Substitution.union(res, sigma);
            }
            return res;
        }
        return null;
    }

    /**
     * the variable to replace
     */
    private final Variable var;
    /**
     * the replacement for the variable
     */
    private final Term term;
    /**
     * the remainder of this substitution
     */
    private final Substitution tail;

    private Substitution(Variable var, Term term, Substitution tail) {
        this.var = var;
        this.term = term;
        this.tail = tail;
    }

    public Substitution(Variable var, Term term) {
        this(var, term, EMPTY);
    }

    /**
     * @param x a variable
     * @return true iff this substitution substitutes the given variable
     */
    private boolean substitutes(Variable x) {
        return this.getTerm(x) != null;
    }

    /**
     * @param x a variable
     * @return the replacement for the given variable or null, if the variable
     * isn't replaced by this substitution
     */
    private Term getTerm(Variable x) {
        if (this.isEmpty()) {
            return null;
        } else if (this.var.toString().equals(x.toString())) {
            return this.term;
        } else {
            return this.tail.getTerm(x);
        }
    }

    /**
     * @return true iff this is the empty substitution
     */
    private boolean isEmpty() {
        return this == EMPTY;
    }

    /**
     * @param t a term
     * @return the term resulting from applying this to t
     */
    public Term apply(Term t) {
        if (t instanceof Variable) {
            return apply((Variable) t);
        } else {
            return apply((FunApp) t);
        }
    }

    public Term apply(Variable x) {
        
        
        if (getTerm(x) != null) {
            return getTerm(x);
        } else {
            return (Term) new Variable(String.valueOf(x));
        }
    }

    private FunApp f;
        
    public FunApp apply(FunApp t) {
        this.f = t;
        if (t.args == null) {
            return t;
        }
        
        if(this.tail == null && this.term == null && this.var == null){
            
            return f;
            
        }
        
        
        
        if (t.args != null ) {
            
            int i = 0;
            return helper(i,t);
        }

        return null;
    }
    
    private FunApp helper(int i,FunApp f){
        if(i == f.args.length){
            return f;
        }
        
        if(f.args != null &&i < f.args.length && f.args[i] instanceof FunApp){
            this.apply(f.args[i]);
            return helper(i+1,f);
        }
        
        if(i < f.args.length && f.args[i] instanceof FunApp ){
             this.apply(f.args[i]);
            return helper(i+1,f);
            
        }
        if(i < f.args.length && f.args[i] instanceof Variable){
           f.args[i] = this.apply((Variable)f.args[i]);
            return helper(i+1,f);
        }
        return helper(i+1,f);
    }

    /**
     * @param anotherSub another substitution
     * @return null if there is a variable that is assigned by both
     * substitutions, this \cup that otherwise
     */
    private static Substitution union(Substitution aSub, Substitution anotherSub) {
        if (aSub.isEmpty()) {
            return anotherSub;
        } else if (anotherSub.isEmpty()) {
            return aSub;
        } else if (anotherSub.substitutes(aSub.var)) {
            return null;
        } else {
            Substitution tail = union(aSub.tail, anotherSub);
            if (tail == null) {
                return null;
            } else {
                return new Substitution(aSub.var, aSub.term, tail);
            }
        }
    }

    public String toString() {
        String res = "[";
        Substitution current = this;
        while (!current.isEmpty()) {
            res += current.var.toString() + '/' + current.term;
            current = current.tail;
        }
        return res + ']';
    }
}
