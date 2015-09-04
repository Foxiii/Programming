/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nordpol.werkstatt.helfer;

import nordpol.Zufall;
import nordpol.werkstatt.KnechtRuprechtException;
import nordpol.werkstatt.Werkstatt;
import nordpol.werkstatt.geschenke.Geschenkartikel;

/**
 *
 * @author Thorsten
 */
public class Verpacker extends Wichtel {

    //Konstrukor für Verpacker
    public Verpacker(String name, Werkstatt werkstatt) {
        super(name, werkstatt, Zufall.zahl(6));

    }

    @Override
    public void arbeite() {
        super.getWerkstatt().getGefertigteArtikel().get(0).setVerpacken(true);
        
        super.getWerkstatt().getVerpackteArtikel().add(super.getWerkstatt().getGefertigteArtikel().get(0));
        this.energieVerlust(berechneEnergieFuer(getWerkstatt().getVerpackteArtikel().get(0)));
        super.getWerkstatt().getGefertigteArtikel().remove(0);
    }

    public void ersatzTaetigkeit() {
        if (getEnergie() > 50) {

            System.out.println("Wichtel " +this.getName() + " ist langweilig und motiviert deshalb die Handwerker.");
            // Motiviere Handwerker
            for (Helfer helfer : getWerkstatt().getHelfer()) {
                if (helfer instanceof Handwerker) {
                    ((Handwerker) helfer).motivation();
                }
            }
        } else {
            entspanne();
            System.out.println(this.getName() + " ist müde ......." + this.getName() + " hat jetzt wieder " + getEnergie() + " Energie");
        }

    }

    public void entspanne() {
        super.entspanne();
        System.out.println("Wichtel " +this.getName() + " entspannt beim streicheln der Rentiere.");

        for (Helfer elfer : getWerkstatt().getHelfer()) {
            if (elfer instanceof Rentier) {
                ((Rentier) elfer).motivation();
            }
        }
    }

    @Override
    public boolean isMuede() {
        return this.getEnergie() <= 10;
    }

    @Override
    public boolean hatArbeit() {

        return super.getWerkstatt().getGefertigteArtikel().isEmpty();
    }

    @Override
    public String toString() {
        return "Wichtel " + this.getName() +  " ( " + "Muetze: " + this.getMuetze()+ ", Energie: "
                + this.getEnergie() + " Hat das Gechenk: " + super.getWerkstatt().getGefertigteArtikel().get(0).toString()+" Verpackt";
    }

    @Override
    public boolean ueberpruefeNaechstesGeschenk() throws KnechtRuprechtException {

        if (getWerkstatt().getGefertigteArtikel().get(0) == null) {

            throw new KnechtRuprechtException();

        }
        return false;

    }

    @Override
    public int berechneEnergieFuer(Geschenkartikel geschenk) {

        return 10 - this.getMuetze();
    }

}
