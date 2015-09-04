package nordpol.werkstatt.geschenke;


/**
 *
 * @author Thorsten
 */
public class Empfaenger {
    private String name;
    private int alter;
    private int konfektion;

    
    public Empfaenger(String name,int alter,int konfektion){
        this.name = name;
        this.alter = alter;
        this.konfektion = konfektion;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    

    /**
     * @return the alter
     */
    public int getAlter() {
        return alter;
    }

    

    /**
     * @return the konfektion
     */
    public int getKonfektion() {
        return konfektion;
    }

    
}
