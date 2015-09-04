package nordpol.werkstatt.geschenke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thorsten
 */
public class Spielzeug extends Geschenkartikel {

    private int mindestalter;

    public Spielzeug(String name, double gewicht, int schwierigkeitsgrad, int mindestalter, Empfaenger e) {
        super(name, gewicht, schwierigkeitsgrad, e);
        this.mindestalter = mindestalter;

    }

    @Override
    public  boolean istGueltig() {
        return this.getMindestalter() <= this.getEmpfaenger().getAlter();
    }

    /**
     * @return the mindestalter
     */
    public int getMindestalter() {
        return mindestalter;
    }

    /**
     * @param mindestalter the mindestalter to set
     */
    public void setMindestalter(int mindestalter) {
        this.mindestalter = mindestalter;
    }
}
