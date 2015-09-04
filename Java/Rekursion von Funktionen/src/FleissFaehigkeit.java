interface FleissFaehigkeit {
    default public String beschreibung(){
        return "Diese Fleissfähigkeit benötigt " + getAusfuehrungsDauer()+ " Sekunden" ;
    }
 public int getAusfuehrungsDauer();
}
