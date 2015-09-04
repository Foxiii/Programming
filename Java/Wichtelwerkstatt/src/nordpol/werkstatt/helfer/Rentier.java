/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nordpol.werkstatt.helfer;


import nordpol.werkstatt.KnechtRuprechtException;
import nordpol.werkstatt.Werkstatt;
import nordpol.werkstatt.geschenke.Geschenkartikel;
import nordpol.werkstatt.geschenke.Kleidungsstueck;
import nordpol.werkstatt.geschenke.Spielzeug;


/**
 *
 * @author Thorsten
 */
public class Rentier extends Helfer {

    private int ps;
    private Rentiermodell model;

    private boolean motivation = false;
    
    //Konsturktor für Rentiere
    public Rentier(String name, Werkstatt werkstatt, int ps, Rentiermodell model) {

        super(name, werkstatt);
        this.ps = ps;
        this.model = model;

    }

    //Energiebonus für Motivation
    public void motivation() {
        energieBonus(5);
    }

    
    
    
    public boolean hatArbeit() {

        return super.getWerkstatt().getVerpackteArtikel().isEmpty();
    }

    @Override
    public int berechneEnergieFuer(Geschenkartikel geschenk) {
        switch (model) {
            case OLDTIMER:
                return 10 + ((int) ((2 * geschenk.getGewicht()) / (getPs())));

            case SPORTLER:
                return 10 + ((int) ((geschenk.getGewicht()) / (getPs())));
        }
        return 5;
    }

    @Override
    public String toString() {
        return this.model + "-Rentier " + this.getName() + "( " + "Energie: "
                + this.getEnergie() + ") Hat das Gechenk: " + super.getWerkstatt().getVerpackteArtikel().get(0).toString() + " ins Lager gebracht.";
    }

    /**
     * @return the ps
     */
    public int getPs() {
        return ps;
    }

    /**
     * @param ps the ps to set
     */
    public void setPs(int ps) {
        this.ps = ps;
    }

    @Override
    public boolean ueberpruefeNaechstesGeschenk() throws KnechtRuprechtException {

        if (getWerkstatt().getVerpackteArtikel().get(0) == null) {

            throw new KnechtRuprechtException();

        }
        return false;

    }

    @Override
    public void arbeite() {
            /*
        Vorgehen immer nach gleichem Prinzip:
        Prüfen welche Art des Artikel ist es.
        Dann in das jeweilige Lager bringen. 
        Energie hierfür berechnen.
        Artikel aus dem Stapel der Verpackten Artikel streichen
        
        */
        if (super.getWerkstatt().getVerpackteArtikel().get(0) instanceof Kleidungsstueck) {
            getWerkstatt().getKleidungslager().geschenkHinzufuegen((Kleidungsstueck) super.getWerkstatt().getVerpackteArtikel().get(0));
            this.energieVerlust(berechneEnergieFuer(getWerkstatt().getVerpackteArtikel().get(0)));
            super.getWerkstatt().getVerpackteArtikel().remove(0);
        } else if (super.getWerkstatt().getVerpackteArtikel().get(0) instanceof Spielzeug) {

            getWerkstatt().getSpielzeuglager().geschenkHinzufuegen((Spielzeug) super.getWerkstatt().getVerpackteArtikel().get(0));
            this.energieVerlust(berechneEnergieFuer(getWerkstatt().getVerpackteArtikel().get(0)));
            super.getWerkstatt().getVerpackteArtikel().remove(0);
        } else if (super.getWerkstatt().getVerpackteArtikel().get(0) instanceof Geschenkartikel) {
            getWerkstatt().getLagerFuerSonstiges().geschenkHinzufuegen((Geschenkartikel) super.getWerkstatt().getVerpackteArtikel().get(0));
            this.energieVerlust(berechneEnergieFuer(getWerkstatt().getVerpackteArtikel().get(0)));
            super.getWerkstatt().getVerpackteArtikel().remove(0);
        }

    }

    
    @Override
    public boolean isMuede() {
        return this.getEnergie() <= 10;
    }

    

    public boolean isRentierMotivation() {
        return motivation;
    }

    /**
     * @param istMotiviert the istMotiviert to set
     */
    public void setRentierMotiviert(boolean istMotiviert) {
        this.motivation = istMotiviert;
    }
}
