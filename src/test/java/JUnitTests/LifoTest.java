package JUnitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LifoTest {
    KellerspeicherMitArray f = null;
    static Integer[] a = {1,2,3,4,5};

    @BeforeEach
    public void setup(){
        f = new KellerspeicherMitArray(5);
    }

    @AfterEach
    public void teardown(){
        f = null;
    }

    @Test
    public void testIsEmpty(){
        assertTrue(f.isEmpty(),"Array ist nicht leer obwohl es das sollte.");
        f.push(1);
        assertFalse(f.isEmpty(), "Array sollte nicht leer sein");
    }

    @Test
    public void testPush(){
        for (int i: a) {
            f.push(i);
            assertEquals(i, f.top(), "Falsches Element");
        }
        assertThrows(IllegalStateException.class,() -> {
            f.push(6);
        });
    }

    @Test
    public void testPop(){
            for (int i : a) {
                f.push(i);
            }
            for (int i = 0; i < 5; i++) {
                assertEquals(5 - i, f.pop(), "Falsches Element");
            }
        assertThrows(NoSuchElementException.class, () -> {
           f.pop();
        });
    }

    @Test
    public void testCapacity(){
        assertEquals(5, f.capacitiy(), "Speichergröße nicht korrekt.");
    }

    @Test
    public void testSize(){
        for (int i: a) {
            f.push(i);
            assertEquals(i, f.size(), "Anzahl der Elemente ungleich.");
        }
    }

    @Test
    public void testTop(){
        for (int i: a) {
            f.push(i);
            assertEquals(i, f.top(), "Falsches Element");
        }
    }
}
