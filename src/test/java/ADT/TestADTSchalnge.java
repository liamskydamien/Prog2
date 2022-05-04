package ADT;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestADTSchalnge {
    static Integer[] a = {1,2,3,4,5};
    SchlangeMitDynArray<Integer> dynSch = new SchlangeMitDynArray<Integer>();

    @BeforeEach
    public void setup(){
        dynSch = new SchlangeMitDynArray<Integer>();
    }

    @AfterEach
    public void teardown(){
        dynSch = null;
    }

    @Test
    public void testeAddAndSize(){
        dynSch.insert(a[1]);
        assertEquals(1, dynSch.size());
        assertEquals(a[1], dynSch.first());
    }

    @Test
    public void testeRemove(){
        dynSch.insert(a[0]);
        dynSch.insert(a[1]);
        assertEquals(2, dynSch.size());
        dynSch.remove();
        assertEquals(1, dynSch.size());
        assertEquals(a[1], dynSch.first());
    }

    @Test
    public void testeIsEmpty(){
        dynSch.insert(a[0]);
        assertFalse(dynSch.isEmpty());
        dynSch.remove();
        assertTrue(dynSch.isEmpty());
    }

    
}
