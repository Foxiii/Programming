
class Metallurgie extends Faehigkeit{
  public int getLernKosten(){
    return 1;
  }
}

class RuestungSchmieden extends Faehigkeit{
  public int getLernKosten(){
    return 10;
  }
}

class PistolenHerstellen extends Faehigkeit{
  public int getLernKosten(){
    return 100;
  }
}

class KuerassiereAusbilden extends Faehigkeit{
  public int getLernKosten(){
    return 1000;
  }
}

public class Main {

  public static void main(String[] args){

    SchattenWandeln s = new SchattenWandeln();
    //sollte folgendes ausgeben:
    //Diese  Zauberfaehigkeit benoetigt 5 Zauberpunkte
    //Diese Fleissfaehigkeit braucht 10 Sekunden
    System.out.println(s.beschreibung());

    Metallurgie m = new Metallurgie();
    RuestungSchmieden r = new RuestungSchmieden();
    PistolenHerstellen p = new PistolenHerstellen();
    KuerassiereAusbilden k = new KuerassiereAusbilden();

    k.bedingungen = new Faehigkeit[]{r,p};
    r.bedingungen = new Faehigkeit[]{m};
    p.bedingungen = new Faehigkeit[]{m};
    m.bedingungen = new Faehigkeit[]{};

    //Sollte 1111 ausgeben
    System.out.println(k.kostenFuerErforschung());
  }
}
