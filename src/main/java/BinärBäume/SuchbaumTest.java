package BinärBäume;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuchbaumTest {
    SortierterIntBaum a = new SortierterIntBaum();

    @BeforeEach
    public void setup(){
        a = new SortierterIntBaum();
        a.add(7);
        a.add(5);
        a.add(3);
        a.add(11);
        a.add(9);
        a.add(12);
        a.add(8);
        a.add(10);
    }

    @AfterEach
    public void teardown(){
        a = null;
    }

    @Test
    public void testeAdd(){
        assertEquals(a.toString(), "(((()3())5())7(((()8())9(()10()))11(()12())))");
        assertTrue(a.contains(10));
        assertFalse(a.contains(15));
    }

    @Test
    public void testeRemove(){
        a.remove(a.root, 9);
        assertEquals(a.toString(),"(((()3())5())7(((()8())10())11(()12())))" );
    }
}
