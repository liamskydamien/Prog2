package Generics;

import JUnitTests.Generics1.KellerspeicherMitArrayG;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LifoGTest {
    KellerspeicherMitArrayG<Integer> f;
    KellerspeicherMitArrayG <Double> g;
    KellerspeicherMitArrayG <String> h;
    static Integer[] a = {1,2,3,4,5};
    static Double[] b = {1.3, 2.5, 3.7, 4.8, 5.6};
    static String[] c ={"a", "b", "c", "d", "e"};

    @BeforeEach
    public void setup(){
        f = new KellerspeicherMitArrayG <Integer>(5);
        g = new KellerspeicherMitArrayG <Double>(5);
        h = new KellerspeicherMitArrayG <String>(5);
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
            assertEquals(i, f.top(), "Falsches Element");
        }
        assertThrows(IllegalStateException.class,() -> {
            f.push(6);
        });

        for (double i : b) {
            g.push(i);
            assertEquals(i, g.top(), "Falsches Element");
        }
        assertThrows(IllegalStateException.class,() -> {
            g.push(6.0);
        });

        for (String i : c) {
            h.push(i);
            assertEquals(i, h.top(), "Falsches Element");
        }
        assertThrows(IllegalStateException.class,() -> {
            h.push("6");
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

        for (double i : b) {
            g.push(i);
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(b[4 - i], g.pop(), "Falsches Element");
        }
        assertThrows(NoSuchElementException.class, () -> {
            g.pop();
        });
        for (String i : c) {
            h.push(i);
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(c[4 - i], h.pop(), "Falsches Element");
        }
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
        int v = 0;
        int p = 0;
        for (int i: a) {
            f.push(i);
            l++;
            assertEquals(l, f.size(), "Anzahl der Elemente ungleich.");
        }
        for (double i: b) {
            g.push(i);
            v++;
            assertEquals(v, g.size(), "Anzahl der Elemente ungleich.");
        }
        for (String i: c) {
            h.push(i);
            p++;
            assertEquals(p, h.size(), "Anzahl der Elemente ungleich.");
        }
    }

    @Test
    public void testTop(){
        for (int i: a) {
            f.push(i);
            assertEquals(i, f.top(), "Falsches Element");
        }

        for (double i: b) {
            g.push(i);
            assertEquals(i, g.top(), "Falsches Element");
        }

        for (String i : c) {
            h.push(i);
            assertEquals(i, h.top(), "Falsches Element");
        }
    }
}
