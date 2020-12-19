package CantorMapping;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Executor {
    public static void main(String args[]){
        MapConverter mapConverter = new MapConverter();
        Sorting sorter = new Sorting();        

        // Part one
        String[] sortLater = {"bac","abc","bach","azzzzzzzzzz","azzzzzzzzzb","z","classic","basketcase","basket"};

        List<Object> res= mapConverter.convertIterabletoCantorMap(sortLater);

        for (Object obj: res){
            System.out.println(obj);
        }
        /*
        Result res = JUnitCore.runClasses(Tester.class);

        for (Failure fail: res.getFailures()){
            System.out.println(fail.toString());
        }

        System.out.println(res.wasSuccessful());
        */
    }
}


/**
      private void trial(){

        String[] sortLater = {"bac","abc","bach","azzzzzzzzzz","azzzzzzzzzb","z","classic","basketcase","basket"};
        double[] cantor_hashed = new double[sortLater.length];

        for(int i=0;i<sortLater.length;i++){
            cantor_hashed[i] = CantorHashing(sortLater[i]);

            System.out.println("String: "+sortLater[i]+" = "+cantor_hashed[i]);
        }


    }
 */