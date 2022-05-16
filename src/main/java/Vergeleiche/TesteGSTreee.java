package Vergeleiche;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteGSTreee {
    private GenericSearchTree<Boxer> gs = new GenericSearchTree<Boxer>(new ComparatorBoxer());
    private static Boxer[] a = {new Boxer("Liam","Hess", 62),
                         new Boxer("Siri", "Senma", 47),
                         new Boxer("Niklas", "Mueseler", 73),
                         new Boxer("Tim","Polland", 70),
                         new Boxer("Vitali", "Klitschko", 102)};

    @BeforeEach
    void setup(){
        gs = new GenericSearchTree<>(new ComparatorBoxer());
        for(int i = 0; i < a.length; i++){
            gs.add(a[i]);
        }
    }

    @AfterEach
    void td(){
        gs = null;
    }

    @Test
    void testeToString(){
        assertEquals("((()Siri, Senma, 47())Liam, Hess, 62((()Tim, Polland, 70())Niklas, Mueseler, 73(()Vitali, Klitschko, 102())))", gs.toString());
    }

    @Test
    void testeInsert(){
        gs.add(new Boxer("Siri", "Senmas", 45));
        gs.add(new Boxer("A", "A", 60));
        assertEquals("(((()Siri, Senmas, 45())Siri, Senma, 47(()A, A, 60()))Liam, Hess, 62((()Tim, Polland, 70())Niklas, Mueseler, 73(()Vitali, Klitschko, 102())))", gs.toString());
    }
}
