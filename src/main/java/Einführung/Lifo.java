package Einführung;

public class Lifo extends AbstractIntegerBuffer implements IntegerBuffer{

    public Lifo(int size){
        super.array = new Integer[size];
    }

    public Lifo(){
        int rSize = (int) (Math.random() * 100);
        if (rSize < 3) {
            super.array = new Integer[3];
        }
        else {
            super.array = new Integer[rSize];
        }
    }

    public int pop(){
        try {
            return super.array[--size];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Fehler: Es befindet sich kein Element mehr im Array.");
            return 0;
        }
    }
/**
    public void push(int s){
    array[size++] = s;
    }
    public int size(){
        return array.length;
    }

    public int capacity(){
        return size;
    }
 */
}
