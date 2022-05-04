package VerketteteListe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EVLTests {
    EVL<Integer> test;
    static Integer[] a = {1,2,3,4,5};

    @BeforeEach
    public void setup(){
        test = new EVL<Integer>();
        for (int o: a) {
            test.addLast(o);
        }
    }

    @AfterEach
    public void teardown(){
        test = null;
    }

    @Test
    public void testAddFirst(){
        test.addFirst(a[0]);
        assertEquals(a[0], test.getFirst().getData(), "Nicht korrekter Wert.");
    }

    @Test
    public void testAddLast(){
        test.addLast(a[0]);
        assertEquals(a[0], test.getLast().getData());
    }

    @Test
    public void testDelete(){
        assertEquals(a[4], test.removeFirst().getData());
        assertEquals(a[0], test.removeLast().getData());
    }
    @Test
    public void testContains(){
        assertTrue(test.contains(5));
        assertFalse(test.contains(6));
    }
    @Test
    public void testSize(){
        assertEquals(5, test.size());
        test.addFirst(6);
        assertEquals(6, test.size());
    }

    @Test
    public void testZip(){
        EVL<Integer> other = new EVL<Integer>();
        Integer[] b = {6,7,8,9};
        for (Integer o: b) {
            other.addLast(o);
        }
        test.zip(other);
        Integer[] c = {1,6,2,7,3,8,4,9,5};
        int i = 0;
        while(test.size() > 0){
            assertEquals(c[i], test.removeFirst().getData());
            i++;
        }
    }
    @Test
    public void testZip2() {
        EVL<Integer> other = new EVL<Integer>();
        Integer[] b = {6, 7, 8, 9, 10, 11, 12};
        for (Integer o : b) {
            other.addLast(o);
        }
        test.zip(other);
        Integer[] c ={1,6,2,7,3,8,4,9,5,10,11,12};
        int i = 0;
        while(test.size() > 0){
            assertEquals(c[i], test.removeFirst().getData());
            i++;
        }
    }

    @Test
    public void testeZIP3(){
        EVL<Integer> other = new EVL<Integer>();
        Integer[] b = {6, 7, 8, 9, 10, 11, 12};
        for (Integer o : b) {
            other.addLast(o);
        }
        Integer[] c = {1,6,2,7,3,8,4,9,5,10,11,12};
        test.zip(other);
        int i = 0;
        while(test.size() > 0){
            assertEquals(c[i], test.removeFirst().getData());
            i++;
        }
    }


}
