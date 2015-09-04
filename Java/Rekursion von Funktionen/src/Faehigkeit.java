
public abstract class Faehigkeit {

    public boolean erlernt;
    public Faehigkeit[] bedingungen;

    public abstract int getLernKosten();

    public int kostenFuerErforschung() {
        int gesamt = 0;

        if (this.erlernt == false) {
            for (Faehigkeit f : this.bedingungen) {
                gesamt += f.kostenFuerErforschung();
            }
            erlernt = true;
            return getLernKosten() + gesamt;
        } else {
            return 0;
        }

    }
}
