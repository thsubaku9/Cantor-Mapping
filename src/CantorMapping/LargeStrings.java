package CantorMapping;

import java.util.Hashtable;
import java.lang.Math;

public class LargeStrings {

    private Hashtable<String,Double> dpLookup;
    
    public LargeStrings(int alphabetSize, int pairSize, int initialFraction,float loadFactor){
        int requiredSpace = (int)Math.pow(alphabetSize, pairSize)/initialFraction;
        dpLookup = new Hashtable<>(requiredSpace,loadFactor);
    }
}
