
public class FunApp extends Term {

    Symbol symbol;
    Term[] args;

    public FunApp(Symbol symbol, Term[] args) {
        this.symbol = symbol;
        this.args = args;
    }

    public FunApp(Symbol symbol) {
        this(symbol, null);
    }

    public Term[] getArgs() {
        return this.args;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public FunApp replaceArg(int i, Term newArg) {
        Term[] newArgs = new Term[args.length];
        for (int j = 0; j < args.length; j++) {
            newArgs[j] = args[j];
        }
        newArgs[i] = newArg;
        return new FunApp(symbol, newArgs);
    }

    public String toString() {

        if (args == null) {
            return this.symbol.toString();
        } else {
            int i = 0;
            String s = "";
            return helper(i, s);
        }

    }

    private String helper(int i, String s) {
        if (i == 0) {
            s += this.getSymbol().toString() + "(" + String.valueOf(this.args[i]) + this.helper(i + 1, s);
        }
        if (i == args.length - 1) {
            s += "," + String.valueOf(this.args[i]) + ")";
        }
        if (i < args.length - 1 && i > 0) {
            s += "," + String.valueOf(this.args[i]) + this.helper(i + 1, s);
        }
        return s;
    }

}
