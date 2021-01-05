package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestMain {
    public static void main(String args[]){
        Result res = JUnitCore.runClasses(Tester.class);
        for (Failure fail: res.getFailures()){
            System.out.println(fail.toString());
        }
        System.out.println(res.wasSuccessful());

        TesterMethods myGenerator = new TesterMethods();
        Object[] vals =  myGenerator.generate_lexi(26*26, 1, 2);

        for (Object v:vals){
            if (v instanceof String) System.out.println((String)v);            
        }
    }   
}
