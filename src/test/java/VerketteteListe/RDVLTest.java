package VerketteteListe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RDVLTest {
    RDVL<Integer> test = new RDVL<Integer>();
    static Integer[] a = {1,2,3,4,5};

    @BeforeEach
    public void setup(){
        test = new RDVL<Integer>();
        for(Integer o : a){
            test.add(o);
            System.out.println(test.element());
        }
        for(int i = 0; i < 5; i++){
            System.out.println(test.element());
            test.next();
        }
    }
    @AfterEach
    public void teardown(){
        test = null;
    }

    @Test
    public void testElementNext(){
        assertEquals(a[4], test.element());
        test.next();
        assertEquals(a[0], test.element());
    }

    @Test
    public void testRemove(){
        test.remove();
        assertEquals(a[0], test.element());
        System.out.println(test.size());
        while(!test.isEmpty()){
            test.remove();
        }
        System.out.println("Leer");
    }

    @Test
    public void testPrev(){
        test.prev();
        assertEquals(a[3], test.element());
    }
}
