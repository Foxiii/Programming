
package nordpol.werkstatt.lager;

import nordpol.werkstatt.geschenke.Geschenkartikel;

import java.util.*;

/**
 *
 * @author Thorsten
 */
public class Lager<G extends Geschenkartikel> {

    private List<G> geschenke = new LinkedList<G>();

    public void geschenkHinzufuegen(G neuesGeschenk) {
        this.geschenke.add(neuesGeschenk);
    }

    public List<List<G>> portioniereGeschenke(int maxGewicht) {
        List<List<G>> portion = new LinkedList<>();
        List<G> aktuelleListe = new LinkedList<>();

        double aktuellesGewicht = 0;

        /*
         * Teile in Portionen ein Durchlaufe alle Geschenke in der List<G> geschenke .
         * Vorgang:
         * # Betrachte Sonderfall: wenn einzelnes Geschenk schwerer als maxGewicht, erzeuge eigene Portion.
         * # Wenn "zukünftige" Portion schwerer ist als  maxGewicht, erzeuge aktuelle Portion.
         * # Füge Objekt zu Liste hinzu.
         * 
         * # Wenn Liste am Ende leer: Erzeuge aus Rest Portion.
         */
        for (G g : geschenke) {

            /* Sonderfall */
            if (g.getGewicht() > maxGewicht) {
                List<G> sonderfall = new LinkedList<>();
                sonderfall.add(g);
                portion.add(sonderfall);
                continue;
            }

            aktuellesGewicht += g.getGewicht();

            if (aktuellesGewicht > maxGewicht) {
                portion.add(aktuelleListe);
                aktuelleListe = new LinkedList<>();
                aktuellesGewicht = g.getGewicht();
            }

            aktuelleListe.add(g);
        }

        if (!aktuelleListe.isEmpty()) {
            portion.add(aktuelleListe);
        }

        return portion;
    }
    public String toString() {
		return this.geschenke.toString();
	}

}
