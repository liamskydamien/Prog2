package JUnitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class FifoTest {
    Warteschlange f = null;
    static Integer[] a = {1,2,3,4,5};

    @BeforeEach
    public void setup(){
        f = new WarteschlangeMitArray(5);
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
            assertEquals(i, f.pop(), "Falsches Element");
        }
        for (int i: a) {
            f.push(i);
        }
        assertThrows(IllegalStateException.class,() -> {
            f.push(6);
        });
    }

    @Test
    public void testPop(){
        f.push(a[0]);
        assertEquals(1, f.pop(), "Falsches Element");
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
    public void testFront(){
        for (int i: a) {
            f.push(i);
            assertEquals(1, f.front(), "Falsches Element");
        }
    }
}
