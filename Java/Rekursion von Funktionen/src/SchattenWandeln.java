class SchattenWandeln extends Faehigkeit implements MagischeFaehigkeit , FleissFaehigkeit {
  public int getLernKosten(){ 
    return 100; 
  }
  public int getAusfuehrungsDauer(){ 
    return 10; 
  }
  public int getZauberKosten(){ 
    return 5; 
  }
  public String beschreibung(){
      return MagischeFaehigkeit.super.beschreibung() + "\n" + FleissFaehigkeit.super.beschreibung();
  }
}
