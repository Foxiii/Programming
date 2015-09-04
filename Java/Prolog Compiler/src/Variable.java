
public class Variable extends Term {
    private String name;
    
    public Variable(String name){
        this.name = name;
    }
    public String toString(){
        return this.name;
    }
}
