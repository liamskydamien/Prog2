package BinärBäume;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BBTest {
    Binaerbaum<Integer> test;
    static Integer[] a = {1,2,3,4,5,6,7};

    @BeforeEach
    public void setup(){
       test = new Binaerbaum<>();
    }

    @AfterEach
    public void teardown(){
        test = null;
    }

    @Test
    public void testeConstructorSizeHöhe(){
        Binaerbaum<Integer> Baum1 = new Binaerbaum<>(a[6], null, null);
        Binaerbaum<Integer> Baum2 = new Binaerbaum<>(a[5], null, null);
        Binaerbaum<Integer> Baum3 = new Binaerbaum<>(a[4], null, null);
        Binaerbaum<Integer> Baum4 = new Binaerbaum<>(a[3], Baum1, Baum2);
        Binaerbaum<Integer> Baum5 = new Binaerbaum<>(a[2], Baum3, null);
        Binaerbaum<Integer> Baum6 = new Binaerbaum<>(a[1], Baum4, Baum5);

        assertFalse(Baum6.isEmpty());
        assertEquals(Baum6.hoehe(), 3, "Höhe stimmt nicht überein.");
        assertEquals(Baum6.size(), 6);
    }

    @Test
    public void testeToString(){
        Binaerbaum<Integer> Baum1 = new Binaerbaum<>(a[6], null, null);
        Binaerbaum<Integer> Baum2 = new Binaerbaum<>(a[5], null, null);
        Binaerbaum<Integer> Baum3 = new Binaerbaum<>(a[4], null, null);
        Binaerbaum<Integer> Baum4 = new Binaerbaum<>(a[3], Baum1, Baum2);
        Binaerbaum<Integer> Baum5 = new Binaerbaum<>(a[2], Baum3, null);
        Binaerbaum<Integer> Baum6 = new Binaerbaum<>(a[1], Baum4, Baum5);

        assertEquals("<7><4><6><2><5><3>",Baum6.toString());
    }

    @Test
    public void testeTrav(){
        Binaerbaum<Integer> Baum1 = new Binaerbaum<>(a[6], null, null);
        Binaerbaum<Integer> Baum2 = new Binaerbaum<>(a[5], null, null);
        Binaerbaum<Integer> Baum3 = new Binaerbaum<>(a[4], null, null);
        Binaerbaum<Integer> Baum4 = new Binaerbaum<>(a[3], Baum1, Baum2);
        Binaerbaum<Integer> Baum5 = new Binaerbaum<>(a[2], Baum3, null);
        Binaerbaum<Integer> Baum6 = new Binaerbaum<>(a[1], Baum4, Baum5);

        assertEquals("2 , 4 , 7 , 6 , 3 , 5 , ", Baum6.preOrder());
        assertEquals("7 , 4 , 6 , 2 , 5 , 3 , ", Baum6.inOrder());
        assertEquals("7 , 6 , 4 , 5 , 3 , 2", Baum6.postOrder());
    }
}
