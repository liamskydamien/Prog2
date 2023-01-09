package ProgrammierÜbungen;

import Datenstrukturen.RingPuffer;

public class TemperaturSensor {
    private final RingPuffer<Float> speicher = new RingPuffer<>(24);
    private int counter = 0;

    public void neueMessung(Float neu){
        try {
            speicher.addLast(neu);
        }
        catch (Exception e){
            speicher.removeFirst();
            speicher.set(counter, neu);
            counter++;
            if(counter == 23){
                counter = 0;
            }
        }
    }

    public Float aktuelleMessung(){
        return speicher.g
    }

}
