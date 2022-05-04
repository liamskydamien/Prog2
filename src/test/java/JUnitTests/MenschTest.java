package JUnitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenschTest {
    private Boxer bP = null;
    private Student sP = null;
    static String[] pM = {"Liam","Hess"};
    static int pS = 9043439;
    static int pB = 65;

    @BeforeEach
    public void setup(){
        bP = new Boxer(pM[0], pM[1],pB);
        sP = new Student(pM[0], pM[1],pS);
    }

    @AfterEach
    public void teardown(){
        bP = null;
        sP = null;
    }

    @Test
    public void testGetVName(){
        assertEquals("Liam", sP.getVName(), "Falsch");
        assertEquals("Liam", bP.getVName(), "Boxer Falsch");
    }

    @Test
    public void testGetName(){
        assertEquals("Hess", sP.getName(), "Falsch");
        assertEquals("Hess", bP.getName(), "Boxer Falsch");
    }

    @Test
    public void testGetMatGew(){
        assertEquals(9043439, sP.getpMatrikel());
        assertEquals(65, bP.getpGewicht());
    }
    @Test
    public void testequals(){
        Student sD = new Student("Siri", "Senma", 90904545);
        assertTrue(sP.equals(sP));
        assertFalse(sP.equals(sD));

        Boxer sE = new Boxer("Siri", "Senma", 56);
        assertTrue(bP.equals(bP));
        assertFalse(bP.equals(sE));
    }

    @Test
    public void testeString(){
        assertEquals("Liam , Hess , 9043439", sP.toString());
        assertEquals("Liam , Hess , 65", bP.toString());
    }




}
