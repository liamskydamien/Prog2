package Datenstrukturen;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPTest {
    RingPuffer<Integer> rp = null;
    static Integer[] a = {1,2,3,4,5};
    @BeforeEach
    public void setup(){
        rp = new RingPuffer<Integer>(5);
    }
    @AfterEach
    public void teardown(){
        rp = null;
    }
    @Test
    public void testeAddRemoveSize(){
        try {
            rp.addFirst(a[0]);
            assertEquals(rp.size(), 1);
            rp.addLast(a[1]);
            rp.addLast(a[2]);
            rp.addLast(a[3]);
            rp.addLast(a[4]);
            assertEquals(rp.size(), 5);
            rp.removeFirst();
            rp.addLast(a[0]);
            assertEquals(rp.size(), 5);
        }catch (Exception e){
            System.out.println("Es wurde eine Exception geworfen");
        }
    }

    @Test
    public void testeRemove() throws Exception {
        try {
            rp.addFirst(a[0]);
            rp.addLast(a[1]);
            rp.addLast(a[2]);
            rp.addLast(a[3]);
            rp.addLast(a[4]);
            assertEquals(rp.size(), 5);
            rp.removeFirst();
            rp.removeLast();
            assertEquals(2, rp.getFirst());
            assertEquals(4, rp.getPos(3));
            assertEquals(rp.size(), 5);
        }catch (Exception e){
            throw e;
        }
    }

    @Test
    public void testeSize(){

    }

    @Test
    public void testeCap(){

    }



}
