package CantorMapping;

import java.util.List;
import java.util.ArrayList;
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
        int[] orderedindex = sorter.mergeSort(indexedArray, values, (a, b) -> {return (Double.compare(a,b))> 0 ? 1 : -1;});
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
        
        Double primary = mapConverter.CantorMap(mainString);

        ArrayList<Double> suffixValues = new ArrayList<>();
        suffixValues.add(primary);
        System.out.println(primary);

        for (int j=0; j<mainString.length()-1; j++) {
            System.out.println(mainString.charAt(j));
            primary = primary - ((double)((int)mainString.charAt(j) - mapConverter.baseValue));
            primary *= mapConverter.x;
            System.out.println(primary);
            suffixValues.add(primary);
        }

        int[] suffix_index_array = sorter.init_index(mainString.length());
        values = Arrays.asList(suffixValues.toArray()).toArray(new Double[0]);

        int[] ordered_suffix_index = sorter.mergeSort(suffix_index_array, values, (a,b) -> {return (Double.compare(a,b))> 0 ? 1 : -1;});

        for (int j=0; j<mainString.length(); j++) {
            System.out.println(ordered_suffix_index[j] + " " + mainString.charAt(ordered_suffix_index[j]));
        }
        //Part three - Radix Sorting
    }
}