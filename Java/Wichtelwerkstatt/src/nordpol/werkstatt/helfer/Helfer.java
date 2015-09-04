/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nordpol.werkstatt.helfer;

import nordpol.werkstatt.KnechtRuprechtException;
import nordpol.werkstatt.Werkstatt;
import nordpol.werkstatt.geschenke.*;

/**
 *
 * @author Thorsten
 */
public abstract class Helfer {

    private String name;
    private int energie = 100;
    private Werkstatt werkstatt;

    @Override
    public abstract String toString();

    public abstract void arbeite();

    public void entspanne() {
        energieBonus(100);
    }

    public abstract boolean hatArbeit();

    public abstract boolean ueberpruefeNaechstesGeschenk() throws KnechtRuprechtException;

    public abstract int berechneEnergieFuer(Geschenkartikel geschenk);

    //Konstruktor für Helfer
    public Helfer(String name, Werkstatt werkstatt) {
        this.name = name;

        this.werkstatt = werkstatt;
    }

    public void ersatzTaetigkeit() {
        this.entspanne();
    }

    public void energieBonus(int bonus) {
        if (this.energie + bonus >= 100) {
            this.energie = 100;
        } else {
            this.energie += bonus;
        }
    }

    public void energieVerlust(int verlust) {
        if (this.energie - verlust <= 0) {
            this.energie = 0;
        }
        this.energie -= verlust;
    }

    public abstract boolean isMuede();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    /**
     * @return the energie
     */
    public int getEnergie() {
        return energie;
    }

    /**
     * @return the werkstatt
     */
    public Werkstatt getWerkstatt() {
        return werkstatt;
    }

}
