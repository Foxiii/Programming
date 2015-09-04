public class Symbol {

    /** the name of this function symbol */
    private final String name;

    public Symbol(String name) {
        this.name = name;
    }

    /**
     * @param that another function symbol
     * @return true iff this function symbol is equal to the given one
     */
    public boolean isEqual(Symbol that) {
        return this.name.equals(that.name);
    }

    public String toString() {
        return this.name;
    }
}
