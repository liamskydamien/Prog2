import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTest {
    @Test
    public void voidTesteTest(){
        Testen Testen = new Testen();
        assertTrue(Testen.testeDas(1));
        assertFalse(Testen.testeDas(2));
    }
}
