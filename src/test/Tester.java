package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tester {
    @Test
    public void initialTest(){
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }
}
