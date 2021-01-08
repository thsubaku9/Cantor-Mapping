package CantorMapping;

import java.util.Hashtable;
import java.lang.Math;

public class LargeStrings {

    private Hashtable<String,Double> dpLookup;    
    private MapConverter myconv;
    public LargeStrings(int alphabetSize, int pairSize, float initialFraction,float loadFactor){        
        int requiredSpace = (int)(Math.pow(alphabetSize, pairSize)*initialFraction);
        myconv = new MapConverter();
        dpLookup = new Hashtable<>(requiredSpace,loadFactor);
    }

    public void insertValue(String prefix){
            dpLookup.put(prefix,myconv.CantorMap(prefix));        
    }

    public double getValue(String prefix){
        if(dpLookup.contains(prefix)){
            return dpLookup.get(prefix);
        } else {
            insertValue(prefix);
            return dpLookup.get(prefix);
        }
    }
}
