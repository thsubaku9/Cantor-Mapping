package CantorMapping;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Executor {
    public static void main(String args[]){
        MapCoverter mapConverter = new MapCoverter();
        Sorting sorter = new Sorting();        

        // Part one

        String[] sortLater = {"bac","abc","bach","azzzzzzzzzz","azzzzzzzzzb","z","classic","basketcase","basket"};

        Result res = JUnitCore.runClasses(Tester.class);

        for (Failure fail: res.getFailures()){
            System.out.println(fail.toString());
        }

        System.out.println(res.wasSuccessful());
    }
}
