package IteratorIterable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteIterator {
    private final Integer[] a = {1,2,3,4,5,6,7,8,9,10};
    private Iterator1DArray<Integer> iterator1DArray;

    @AfterEach
    void td(){
        iterator1DArray = null;
    }

    @Test
    void testeSimple(){
        int i = 0;
        iterator1DArray = new Iterator1DArray<>(a);
        assertTrue(iterator1DArray.hasNext());
        while (iterator1DArray.hasNext()){
            assertEquals(a[i], iterator1DArray.next());
            i++;
        }
        assertFalse(iterator1DArray.hasNext());
    }

    @Test
    void testeAdvanced(){
        int i = 6;
        iterator1DArray = new Iterator1DArray<>(a, 6);
        assertTrue(iterator1DArray.hasNext());
        while (iterator1DArray.hasNext()){
            assertEquals(a[i], iterator1DArray.next());
            i++;
        }
        assertFalse(iterator1DArray.hasNext());
    }

    @Test
    void testeAdvanced2(){
        int i = 3;
        iterator1DArray = new Iterator1DArray<>(a, 3, 7);
        assertTrue(iterator1DArray.hasNext());
        while (iterator1DArray.hasNext()){
            assertEquals(a[i], iterator1DArray.next());
            i++;
        }
        assertFalse(iterator1DArray.hasNext());
    }
}
