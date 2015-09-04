package nordpol.werkstatt.geschenke;


import nordpol.Zufall;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thorsten
 */
public class Geschenkartikel {

    private String name;
    private double gewicht;
    private int schwierigkeitsgrad;
    private Empfaenger empfaenger;
    private boolean verpackt;

    public Geschenkartikel(String name, double gewicht, int schwierigkeitsgrad, Empfaenger empfaenger) {
        this.name = name;
        this.gewicht = gewicht;
        this.schwierigkeitsgrad = schwierigkeitsgrad;
        this.empfaenger = empfaenger;

    }

    public static Geschenkartikel zufaelligerWunsch(Empfaenger empfaenger) {

        int z = Zufall.zahl(3);
        switch (z) {
            case 0:
                return new Geschenkartikel(Zufall.geschenkartikel(), Zufall.gewicht(100), Zufall.zahl(20), empfaenger);

            case 1:
                return new Spielzeug(Zufall.spielzeug(), Zufall.gewicht(20), Zufall.zahl(20), Zufall.zahl(17), empfaenger);

        }

        return new Kleidungsstueck(Zufall.kleidung(), Zufall.gewicht(1), Zufall.zahl(20), 1, empfaenger);
    }

    public boolean istGueltig() {

        return true;
    }

    public String toString() {
        return this.getName() + "(" + this.getGewicht() + "kg)";
    }

    
    public String getName() {
        return name;
    }

    
    public double getGewicht() {
        return gewicht;
    }

    
    
    public int getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    
    public Empfaenger getEmpfaenger() {
        return empfaenger;
    }

    
    public boolean isVerpacken() {
        return verpackt;
    }

    
    public void setVerpacken(boolean verpacken) {
        this.verpackt = verpacken;
    }

}
