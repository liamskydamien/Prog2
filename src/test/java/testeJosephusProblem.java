import ProgrammierÜbungen.JosephusProblem;
import VerketteteListe.Joesphus;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import static org.testng.AssertJUnit.assertEquals;

public class testeJosephusProblem{

    @Test
    void teste_5_2(){
        AssertJUnit.assertEquals(3, Joesphus.loese(5,2));
        AssertJUnit.assertEquals(3, JosephusProblem.loese(5,2));
    }
}
