package test;

import CantorMapping.*;
import java.util.List;
import java.util.Arrays;
import java.time.Instant;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Executor {
    public static void main(String args[]){        
        MapConverter mapConverter = new MapConverter();
        Sorting sorter = new Sorting();        

        // Part one - Standard Sorting
        System.out.println("STADARD SORTING");
        String[] sortLater = {"zimmer","kernel","lambasted","bac","abc","bach","azzzzzzzzzz","azzzzzzzzzb","z","classic","basketcase","basket"};
        
        List<Double> cMapped= mapConverter.convertIterabletoCantorMap(sortLater);        

        int[] indexedArray = sorter.init_index(cMapped.size());
        Double[] values = Arrays.asList(cMapped.toArray()).toArray(new Double[0]);
        
        long startTime = Instant.now().toEpochMilli();
        int[] orderedindex = sorter.mergeSort(indexedArray, values, (a, b) -> {return (int)Double.compare(a,b);});
        long stopTime = Instant.now().toEpochMilli();

        //sorter.printIndexToValues(orderedindex, sortLater);
        
        ComparatorInterface<String> stringCmp = (a,b) -> {            
            for ( int i=0; i < a.length() && i < b.length(); i++){
                if(a.charAt(i) != b.charAt(i)){
                    return ((int)a.charAt(i) - (int)b.charAt(i));
                }                
            }
            return a.length() - b.length();
        };
                        
        int[] indexedArray2 = sorter.init_index(sortLater.length);

        long startTime2 = Instant.now().toEpochMilli();
        int[] orderedindex2 = sorter.mergeSort(indexedArray2, sortLater, stringCmp);
        long stopTime2 = Instant.now().toEpochMilli();

        System.out.println(stopTime - startTime);
        System.out.println(stopTime2 - startTime2);
 
        /*
        Result res = JUnitCore.runClasses(Tester.class);

        for (Failure fail: res.getFailures()){
            System.out.println(fail.toString());
        }

        System.out.println(res.wasSuccessful());
        */

        //Part two - Suffix Sorting
        System.out.println("SUFFIX SORTING");
        String mainString = "mercibeaucoup";
        
        suffixToMap sconv = new suffixToMap(mainString);

        int[] suffix_index_array = sorter.init_index(mainString.length());        

        int[] ordered_suffix_index = sorter.mergeSort(suffix_index_array, sconv.getCantorValue(), (a,b) -> {return (int)Double.compare(a,b);});

        for (int j=0; j<mainString.length(); j++) {
            System.out.println(ordered_suffix_index[j] + " " + mainString.charAt(ordered_suffix_index[j]));
        }
        //Part three - Radix Sorting
        System.out.println("RADIX SORTING");

        radixToMap rconv = new radixToMap(4);

        Double[][] resultChunks = rconv.createRadixArray(sortLater);
        /*
        for (int j=0; j<resultChunks.length; j++){
            for (int j1=0; j1<resultChunks[j].length; j1++)System.out.println(resultChunks[j][j1]);
            System.out.println();
        }
        */
        ComparatorInterface<Double[]> rcomp = (a,b) -> {
            for(int pos = 0; pos<a.length && pos<b.length; pos++){
                if(Double.compare(a[pos], b[pos])==0) continue;
                else return (int)Double.compare(a[pos], b[pos]);
            }
            return a.length - b.length;
        };
        
        int[] radix_indexed_array = sorter.init_index(sortLater.length);
        int[] orderedindex3 = sorter.mergeSort(radix_indexed_array, resultChunks, rcomp);

        sorter.printIndexToValues(orderedindex3, sortLater);
    }    
}