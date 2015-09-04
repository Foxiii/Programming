package nordpol.werkstatt;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import nordpol.Zufall;
import nordpol.werkstatt.geschenke.*;
import nordpol.werkstatt.helfer.*;
import nordpol.werkstatt.lager.*;

public class Werkstatt {

    private Helfer[] helfer;
    private List<Geschenkartikel> wunschzettel;
    private Stack<Geschenkartikel> gefertigteArtikel;
    private Stack<Geschenkartikel> verpackteArtikel;

    private Lager<Spielzeug> spielzeuglager;
    private Lager<Kleidungsstueck> kleidungslager;
    private Lager<Geschenkartikel> lagerFuerSonstiges;

    public static void main(String[] args) throws KnechtRuprechtException {

        Werkstatt w = new Werkstatt();

        w.sammleHelfer();
        w.wunschzettelAnlegen();
        w.gefertigteArtikel = new Stack<Geschenkartikel>();
        w.verpackteArtikel = new Stack<Geschenkartikel>();
        w.spielzeuglager = new Lager<Spielzeug>();
        w.kleidungslager = new Lager<Kleidungsstueck>();
        w.lagerFuerSonstiges = new Lager<Geschenkartikel>();

        System.out.println("********************* Wunschzettel **********************");
        System.out.println(w.getWunschzettel());

        System.out.println("*********************************************************");

        w.schickeArbeiter();

        // Teile Geschenke in fuer den Weihnachtsmann tragbare 100kg-Portionen ein.
        System.out.println("Die Lager teilen ihre Geschenke in Portionen ein:");
        System.out.println("************** Portionen im Spielzeuglager **************");
        System.out.println(w.getSpielzeuglager().portioniereGeschenke(100));
        System.out.println("************** Portionen im Kleidungslager **************");
        System.out.println(w.getKleidungslager().portioniereGeschenke(100));
        System.out.println("*********** Portionen im Lager fuer Sonstiges ***********");
        System.out.println(w.getLagerFuerSonstiges().portioniereGeschenke(100));
        System.out.println("*********************************************************");
    }

    private void sammleHelfer() {
        this.helfer = new Helfer[5];
        this.helfer[0] = new Handwerker("Alva", this);
        this.helfer[1] = new Verpacker("Balduin", this);
        this.helfer[2] = new Verpacker("Cora", this);
        this.helfer[3] = new Rentier("Rudolph", this, 8, Rentiermodell.SPORTLER);
        this.helfer[4] = new Rentier("Emma", this, 3, Rentiermodell.OLDTIMER);

    }

    private void wunschzettelAnlegen() {

        int i = 0;
        int zahl = 0;
        List<Geschenkartikel> g = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (zahl <= 0) {

            try {

                zahl = Integer.parseInt(br.readLine());
                if (zahl <= 0) {
                    System.out.println("Bitte eine Zahl größer 0 eingeben.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Fehler hier wurde eine Exeption gefangen. Bitte eine Zahl eingeben.");
            } catch (IOException ex) {
                Logger.getLogger(Werkstatt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (zahl >= i) {

            Geschenkartikel s = Geschenkartikel.zufaelligerWunsch(new Empfaenger(Zufall.name(), Zufall.zahl(121), Zufall.zahl(61)));
            g.add(s);

            i++;
        }

        wunschzettel = g;

    }

    
    private void schickeArbeiter() throws KnechtRuprechtException {
        int z = 0;
        while (fertig() != true) {

            int i = Zufall.zahl(helfer.length - 1);
            z++;
            if (z  == helfer.length){
                status();
                z=0;
            }
            

            if (helfer[i].hatArbeit() != true) {
                System.out.println(helfer[i].toString());
                try {
                    if (helfer[i].ueberpruefeNaechstesGeschenk() != true) {

                    }
                } catch (KnechtRuprechtException e) {
                    System.out.println(e.getMessage());
                }
                helfer[i].arbeite();
            } else {
                helfer[i].ersatzTaetigkeit();
            }

            if (helfer[i].isMuede() == true) {

                helfer[i].entspanne();

            }
           
             
        }

    }

    private void status() {
        System.out.println("************** Offene Wuensche ****************");
        System.out.println(wunschzettel);
        System.out.println("************** Spielzeuglager *****************");
        System.out.println(spielzeuglager);
        System.out.println("************** Kleidungslager *****************");
        System.out.println(kleidungslager);
        System.out.println("*********** Lager fuer Sonstiges **************");
        System.out.println(lagerFuerSonstiges);

    }

    private boolean fertig() {
        return !(wunschzettel.isEmpty() != true || gefertigteArtikel.isEmpty() != true || verpackteArtikel.isEmpty() != true);
    }

    /**
     * @return the wunschzettel
     */
    public List<Geschenkartikel> getWunschzettel() {
        return wunschzettel;
    }

    /**
     * @return the gefertigteArtikel
     */
    public Stack<Geschenkartikel> getGefertigteArtikel() {
        return gefertigteArtikel;
    }

    /**
     * @return the verpackteArtikel
     */
    public Stack<Geschenkartikel> getVerpackteArtikel() {
        return verpackteArtikel;
    }

    /**
     * @return the spielzeuglager
     */
    public Lager<Spielzeug> getSpielzeuglager() {
        return spielzeuglager;
    }

    /**
     * @return the kleidungslager
     */
    public Lager<Kleidungsstueck> getKleidungslager() {
        return kleidungslager;
    }

    /**
     * @return the lagerFuerSonstiges
     */
    public Lager<Geschenkartikel> getLagerFuerSonstiges() {
        return lagerFuerSonstiges;
    }

    /**
     * @return the helfer
     */
    public Helfer[] getHelfer() {
        return helfer;
    }
}
