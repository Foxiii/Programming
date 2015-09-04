interface MagischeFaehigkeit {
  default public String beschreibung(){
        return "Diese Magische Fähigkeit kostet " + getZauberKosten()+ " Zauberpunkte" ;
    }
  public int getZauberKosten();
}
