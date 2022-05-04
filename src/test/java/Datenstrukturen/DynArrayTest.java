package Datenstrukturen;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynArrayTest {
    DynArray<Integer> t;
    static Integer[] a = {1,2,3,4,5};

    @BeforeEach
    public void setup(){
        t = new DynArray<Integer>();
    }

    @AfterEach
    public void teardown(){
        t = null;
    }

    @Test
    public void testAddFirstAndGet(){
        t.addFirst(a[0]);
        assertEquals(a[0], t.get(0));
        t.addFirst(a[1]);
        assertEquals(a[1], t.get(0));
    }

    @Test
    public void testSizeAndCapacity(){
        t.addFirst(a[0]);
        t.addFirst(a[1]);
        assertEquals(2, t.size());
        assertEquals(2, t.capacity());
        t.addFirst(a[2]);
        assertEquals(3, t.size());
        assertEquals(4, t.capacity());
    }

    @Test
    public void testAddLastAndGet(){
        t.addLast(a[0]);
        assertEquals(a[0], t.get(0));
        t.addLast(a[1]);
        assertEquals(a[1], t.get(1));
        t.addLast(a[2]);
        assertEquals(a[2], t.get(t.size()-1));
    }

    @Test
    public void testSet(){
        t.addFirst(a[0]);
        t.addFirst(a[1]);
        t.set(1,a[2]);
        assertEquals(a[2], t.get(1));
    }

    @Test
    public void testRemoveFirst(){
        t.addFirst(a[0]);
        t.addFirst(a[1]);
        t.addLast(a[2]);
        assertEquals(a[1], t.removeFirst());
        assertEquals(2, t.size());
        assertEquals(4, t.capacity());
        t.removeFirst();
        assertEquals(2, t.capacity());
    }

    @Test
    public void testRemoveLast(){
        t.addFirst(a[0]);
        t.addLast(a[1]);
        t.addLast(a[2]);
        assertEquals(a[2], t.removeLast());
        assertEquals(2, t.size());
        assertEquals(4, t.capacity());
        t.removeLast();
        assertEquals(2, t.capacity());
    }
}
