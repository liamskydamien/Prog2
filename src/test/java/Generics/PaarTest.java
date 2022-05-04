package Generics;

import JUnitTests.Generics1.Paar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaarTest {
    Paar<Integer, String> t;
    Paar<Integer, Integer> z;

    @BeforeEach
    public void setup(){
        t = new Paar<Integer, String>();
        z = new Paar<Integer, Integer>();
    }

    @AfterEach
    public void teardown(){
        t = null;
        z = null;
    }

    @Test
    public void testeSetGetErstes(){
        t.setErstes(1);
        z.setErstes(1);

        assertEquals(1, t.getErstes());
        assertEquals(1, z.getErstes());
    }
    @Test
    public void testeSetGetZweites(){
        t.setZweites("1");
        z.setZweites(1);
        assertEquals("1", t.getZweites());
        assertEquals(1, z.getZweites());
    }
    @Test
    public void testeEquals(){
        Paar<Integer, String> test = new Paar<Integer, String>();
        test.setBeide(1, "1");
        t.setBeide(1, "1");
        z.setBeide(1, 1);

        assertTrue(t.equals(test));
        assertFalse(t.equals(z));
    }
    @Test
    public void testeString(){
        t.setBeide(1, "1");
        assertEquals("(1 , 1)", t.toString());
    }

}
