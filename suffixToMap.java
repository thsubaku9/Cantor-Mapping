package CantorMapping;

public class suffixToMap {
    
    private String mainString;
    private MapConverter internalConv;
    private Double[] cantorValue;
    suffixToMap(String mainString){
        this.mainString = mainString;
        internalConv = new MapConverter();
        cantorValue = new Double[this.mainString.length()];

        processValue();
    }

    private void processValue(){
        Double primary = internalConv.CantorMap(mainString);
        
        cantorValue[0] = primary;

        for (int j=0; j<mainString.length()-1; j++) {            
            primary = primary - ((int)mainString.charAt(j) - internalConv.baseValue);
            primary *= internalConv.x;
            cantorValue[j+1] = primary;
        }
    }
    public Double[] getCantorValue(){
        return cantorValue;
    }
    public String getMainString(){
        return mainString;
    }
}
