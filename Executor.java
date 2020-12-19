package CantorMapping;

import java.util.List;
import java.util.Arrays;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Executor {
    public static void main(String args[]){
        MapConverter mapConverter = new MapConverter();
        Sorting sorter = new Sorting();        

        // Part one - Standard Sorting
        String[] sortLater = {"bac","abc","bach","azzzzzzzzzz","azzzzzzzzzb","z","classic","basketcase","basket"};

        List<Double> cMapped= mapConverter.convertIterabletoCantorMap(sortLater);        

        int[] indexedArray = sorter.init_index(cMapped.size());
        Double[] values = Arrays.asList(cMapped.toArray()).toArray(new Double[0]);        
        int[] orderedindex = sorter.mergeSort(indexedArray, values, (a, b) -> {return (a.doubleValue() - b.doubleValue())> 0 ? 1 : -1;});
        
        sorter.printIndexToValues(orderedindex, sortLater);
        /*
        Result res = JUnitCore.runClasses(Tester.class);

        for (Failure fail: res.getFailures()){
            System.out.println(fail.toString());
        }

        System.out.println(res.wasSuccessful());
        */
    }
}