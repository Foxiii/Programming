/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nordpol.werkstatt.helfer;

import nordpol.werkstatt.KnechtRuprechtException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nordpol.Zufall;
import nordpol.werkstatt.Werkstatt;
import nordpol.werkstatt.geschenke.Geschenkartikel;

/**
 *
 * @author Thorsten
 */
public class Handwerker extends Wichtel {

    private static boolean motivation = false;

    public void motivation() {
        motivation = true;
    }

    public Handwerker(String name, Werkstatt werkstatt) {
        super(name, werkstatt, Zufall.zahl(6));

    }

    public void arbeite() {

        if (isHandwerkerMotivation() == true && getWerkstatt().getWunschzettel().size()>1) {
            super.getWerkstatt().getGefertigteArtikel().add(super.getWerkstatt().getWunschzettel().get(0));
            
            this.energieVerlust(berechneEnergieFuer(getWerkstatt().getWunschzettel().get(0)));
            
            super.getWerkstatt().getWunschzettel().remove(0);
            super.getWerkstatt().getGefertigteArtikel().add(super.getWerkstatt().getWunschzettel().get(0));
            this.energieVerlust(berechneEnergieFuer(getWerkstatt().getWunschzettel().get(0)));
            super.getWerkstatt().getWunschzettel().remove(0);

        } else {
            super.getWerkstatt().getGefertigteArtikel().add(super.getWerkstatt().getWunschzettel().get(0));
            this.energieVerlust(berechneEnergieFuer(getWerkstatt().getWunschzettel().get(0)));
            super.getWerkstatt().getWunschzettel().remove(0);
        }

    }

    public String toString() {
        return "Wichtel " + this.getName() + " (" + "Muetze: " + getMuetze() + ", Energie: "
                + this.getEnergie() + " Hat das Gechenk: " + super.getWerkstatt().getWunschzettel().get(0).toString() + " Angefertigt.";
    }

   

   

    public boolean hatArbeit() {
        return getWerkstatt().getWunschzettel().isEmpty();

    }

    public boolean ueberpruefeNaechstesGeschenk() throws KnechtRuprechtException {

        if (getWerkstatt().getWunschzettel().get(0) == null) {

            throw new KnechtRuprechtException();

        }

        while (super.getWerkstatt().getWunschzettel().get(0).istGueltig() != true) {
            super.getWerkstatt().getWunschzettel().remove(0);
        }

        return getEnergie() - berechneEnergieFuer(super.getWerkstatt().getWunschzettel().get(0)) >= 0;

    }

    @Override
    public int berechneEnergieFuer(Geschenkartikel geschenk) {
        return 5 + geschenk.getSchwierigkeitsgrad() - this.getMuetze();
    }

    /**
     * @return the istMotiviert
     */
    public boolean isHandwerkerMotivation() {
        return motivation;
    }

    /**
     * @param istMotiviert the istMotiviert to set
     */
    public void setHandwerkerMotiviert(boolean istMotiviert) {
        this.motivation = istMotiviert;
    }

    @Override
    public boolean isMuede() {
        return this.getEnergie() <= 10;
    }
    
}
