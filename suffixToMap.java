package CantorMapping;

public class suffixToMap {
    
    private String mainString;
    private MapConverter internalConv;
    private Double[] cantorValue;
    suffixToMap(String mainString){
        this.mainString = mainString;
        internalConv = new MapConverter();
        cantorValue = new Double[this.mainString.length()];
    }

    public Double[] returnRepresentation(){

        return cantorValue;
    }
}
