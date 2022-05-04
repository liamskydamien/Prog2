package VerketteteListe;

import JUnitTests.Generics1.WarteschlangeMitArrayG;

public class TimeTest {
    public static void main(String[] args){
        WarteschlangeMitEVL<Integer> evlFifo = new WarteschlangeMitEVL<Integer>();
        WarteschlangeMitArrayG <Integer> arrayFifo = new WarteschlangeMitArrayG<Integer>(100000);

        long startW = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            evlFifo.push(i);
        }
        for(int i = 100000; i > 0; i--){
            evlFifo.pop();
        }
        long stopW = System.currentTimeMillis();
        long zeit1 = stopW - startW;

        long startV = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            arrayFifo.push(i);
        }
        for(int i = 100000; i > 0; i--){
            arrayFifo.pop();
        }
        long stopV = System.currentTimeMillis();
        long zeit2 = stopV - startV;
        System.out.println("Die Laufzeit der EVL-Warteschlange beträgt:" + zeit1);
        System.out.println("Die Laufzeit der Array-Warteschlange beträgt:" + zeit2);

    }

}
