package VerketteteListe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarteschlangeTests {
    WarteschlangeMitEVL<Integer> test;
    static Integer[] a = {1,2,3,4,5};

    @BeforeEach
    public void setup(){
        test = new WarteschlangeMitEVL<Integer>();
    }

    @AfterEach
    public void teardown(){
        test = null;
    }

    @Test
    public void testAddFront(){
        test.push(a[0]);
        assertEquals(test.front(), a[0]);
    }

    @Test
    public void testAddPop(){
        test.push(a[0]);
        assertEquals(test.pop(), a[0]);
    }

    @Test
    public void testSizeCapacity() {
        for (Integer o : a) {
            test.push(o);
        }
        assertEquals(test.size(), 5);
        assertEquals(test.capacitiy(), Integer.MAX_VALUE);
    }
}
