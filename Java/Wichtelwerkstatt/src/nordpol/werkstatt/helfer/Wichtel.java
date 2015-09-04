/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nordpol.werkstatt.helfer;


import nordpol.werkstatt.Werkstatt;

/**
 *
 * @author Thorsten
 */
public abstract class Wichtel extends Helfer {
    
    private int muetze ;
    
    
    //Konsturktor für Wichtel
     public Wichtel(String name, Werkstatt werkstatt,int muetze){
         super(name,werkstatt);
         this.muetze = muetze;
         
         
         
     }

    /**
     * @return the muetze
     */
    public int getMuetze() {
        return muetze;
    }
    
    
    
    
    
}
