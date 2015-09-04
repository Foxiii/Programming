package nordpol.werkstatt.geschenke;


import nordpol.werkstatt.geschenke.Geschenkartikel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thorsten
 */
public class Kleidungsstueck extends Geschenkartikel{
    private int groesse;
     
    
public Kleidungsstueck (String name, double gewicht, int schwierigkeitsgrad,int grosse,Empfaenger e){
    super(name,gewicht,schwierigkeitsgrad,e);
    this.groesse = grosse;
}
 
    /**
     * @return the groesse
     */
    public int getGroesse() {
        return groesse;
    }

    /**
     * @param groesse the groesse to set
     */
    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }
    
    
}
