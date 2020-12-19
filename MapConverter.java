/**
 * To be showcased using:
 * 1. Standard Sorting - l*n + n*log(n)
 * 2. Radix Sorting - l*n + k*n*log(n)
 * 3. Suffix Sorting
 */

package CantorMapping;

import java.util.ArrayList;
import java.util.List;

class MapConverter {

    final float x;
    final float scale;
    final int baseValue;

    MapConverter(){
        x = 30.0f;
        scale = 10.0f;
        baseValue = (int)'a' - 1;
    }
    MapConverter(float x, float scale, int baseValue){
        this.x = x;
        this.scale = scale;
        this.baseValue = baseValue;
    }        

    public List<Object> convertIterabletoCantorMap(ArrayList<Object> array){
        List<Object> returnArray = new ArrayList<Object>(array.size());
        for(Object obj : array){
            returnArray.add(CantorMap(obj.toString()));
        }
        return returnArray;
    }

    public List<Object> convertIterabletoCantorMap(Object[] array){
        List<Object> returnArray = new ArrayList<Object>(array.length);
        for(Object obj : array){
            returnArray.add(CantorMap(obj.toString()));
        }
        return returnArray;
    }

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
}