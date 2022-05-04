package Einführung;

public abstract class AbstractIntegerBuffer implements  IntegerBuffer {
    protected int size = 0;         //Platzhalter für die aktuelle Größe des Arrays
    protected Integer[] array;      //Zwischenspeicher

    /**
     * @name + push(int i): void
     * @param i
     * @Funktion Hängt ein neues Element dem Array an. Bei Fehlern wird die Exeception je nach Fall geklärt.
     */
    
    public void push(int i){
       try{array[size++] = i;}      //Methode: Neues Element i an der Stelle  size + 1 hinzugefügt.
       catch (IllegalArgumentException e){
           System.out.println("Fehler: Bitte Integer in das Array einfügen."); //Fehlerbehandlung im Fall "IllegalArgument".
       }
       catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Fehler: Kapazität des Arrays überschritten.");  //Fehlerbehandlung im Fall "ArrayIndexOutOfBounds".
       }

    }

    public int capacity(){
        return array.length;
    }

    public int size(){
        return size;
    }
}
