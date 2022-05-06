package Generics;

import JUnitTests.Generics1.WarteschlangeMitArrayG;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class FifoGTest {
    WarteschlangeMitArrayG<Integer> f;
    WarteschlangeMitArrayG <Double> g;
    WarteschlangeMitArrayG <String> h;
    static Integer[] a = {1,2,3,4,5};
    static Double[] b = {1.3, 2.5, 3.7, 4.8, 5.6};
    static String[] c ={"a", "b", "c", "d", "e"};

    @BeforeEach
    public void setup(){
        f = new WarteschlangeMitArrayG<Integer>(5);
        g = new WarteschlangeMitArrayG<Double>(5);
        h = new WarteschlangeMitArrayG<String>(5);
    }

    @AfterEach
    public void teardown(){
        f = null;
        g = null;
        h = null;
    }

    @Test
    public void testIsEmpty(){
        assertTrue(f.isEmpty(),"Array ist nicht leer obwohl es das sollte.");
        f.push(1);
        assertFalse(f.isEmpty(), "Array sollte nicht leer sein");

        assertTrue(g.isEmpty(),"Array ist nicht leer obwohl es das sollte.");
        g.push(1.0);
        assertFalse(g.isEmpty(), "Array sollte nicht leer sein");

        assertTrue(h.isEmpty(),"Array ist nicht leer obwohl es das sollte.");
        h.push("a");
        assertFalse(h.isEmpty(), "Array sollte nicht leer sein");
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

        for (double i : b) {
            g.push(i);
            assertEquals(i, g.pop(), "Falsches Element");
        }
        for (double i : b) {
            g.push(i);
        }
        assertThrows(IllegalStateException.class,() -> {
            g.push(6.0);
        });

        for (String i : c) {
            h.push(i);
            assertEquals(i, h.pop(), "Falsches Element");
        }
        for (String i : c) {
            h.push(i);
        }
        assertThrows(IllegalStateException.class,() -> {
            h.push("6");
        });
    }

    @Test
    public void testPop(){
        f.push(a[0]);
        assertEquals(a[0], f.pop(), "Falsches Element");
        assertThrows(NoSuchElementException.class, () -> {
            f.pop();
        });
        g.push(b[0]);
        assertEquals(b[0], g.pop(), "Falsches Element");
        assertThrows(NoSuchElementException.class, () -> {
            g.pop();
        });
        h.push(c[0]);
        assertEquals(c[0], h.pop(), "Falsches Element");
        assertThrows(NoSuchElementException.class, () -> {
            h.pop();
        });
    }

    @Test
    public void testCapacity(){
        assertEquals(5, f.capacitiy(), "Speichergröße nicht korrekt.");
        assertEquals(5, g.capacitiy(), "Speichergröße nicht korrekt.");
        assertEquals(5, h.capacitiy(), "Speichergröße nicht korrekt.");
    }

    @Test
    public void testSize(){
        int l = 0;
        int e = 0;
        int m = 0;
        for (int i: a) {
            f.push(i);
            l++;
            assertEquals(l, f.size(), "Anzahl der Elemente ungleich.");
        }
        for (double i: b) {
            g.push(i);
            e++;
            assertEquals(e, g.size(), "Anzahl der Elemente ungleich.");
        }
        for (String i: c) {
            h.push(i);
            m++;
            assertEquals(m, h.size(), "Anzahl der Elemente ungleich.");
        }
    }

    @Test
    public void testFront(){
            f.push(a[0]);
            assertEquals(a[0], f.front(), "Falsches Element");

            g.push(b[0]);
            assertEquals(b[0], g.front(), "Falsches Element");

            h.push(c[0]);
            assertEquals(c[0], h.front(), "Falsches Element");
    }
}