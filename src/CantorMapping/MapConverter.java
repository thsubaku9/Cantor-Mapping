/**
 * To be showcased using:
 * 1. Standard Sorting - l*n + n*log(n) vs 2*l*n
 * 2. Radix Sorting - l*n + k*n*log(n) vs 2*l*n
 * 3. Suffix Sorting - l + l*log(l) vs l*log(l)
 */

package CantorMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapConverter {

    public final float x;    
    public final int baseValue;

    public MapConverter(){
        x = 30.0f;        
        baseValue = (int)'a' - 1;
    }
    public MapConverter(float x, int baseValue){
        this.x = x;        
        this.baseValue = baseValue;
    }        

    public List<Double> convertIterabletoCantorMap(ArrayList<Object> array){
        List<Double> returnArray = new ArrayList<>(array.size());
        for(Object obj : array){
            returnArray.add(CantorMap(obj.toString()));
        }
        return returnArray;
    }

    public List<Double> convertIterabletoCantorMap(Object[] array){
        List<Double> returnArray = new ArrayList<>(array.length);
        for(Object obj : array){
            returnArray.add(CantorMap(obj.toString()));
        }
        return returnArray;
    }

    /**
     * The default Cantor Mapping function
     * 
     * @param s - String object to be converted
     * @return double - the converted numerical value
     */
    public double CantorMap(String s) {        
        double result = 0.0d, temp, iterativePolynomial = 1.0d;
        for(char character: s.toCharArray())
        {
            temp = ((int)character - baseValue)*iterativePolynomial;
            iterativePolynomial/= x;
            result+=temp;
        }
        return result;
    }

    /**
     * The custom order based Cantor Mapping function
     * 
     * @param s - String object to be converted
     * @param lookupValue - Map for looking up custom order of given Character
     * @return double - the converted numerical value
     */
    public double CantorMap(String s, Map<Character,Number> lookupValue){
        double result = 0.0d, temp, iterativePolynomial = 1.0d;
        for (char c : s.toCharArray()){
            temp = (Double)lookupValue.get(c) * iterativePolynomial;            
            iterativePolynomial/=x;
            result += temp;
        }
        return result;
    }
}