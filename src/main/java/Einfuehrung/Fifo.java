package Einfuehrung;

public class Fifo extends AbstractIntegerBuffer implements IntegerBuffer{

    public Fifo(int size){
        super.array = new Integer[size];
    }

    public Fifo(){
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
            int res = super.array[0];
            for (int i = 0; i <= super.size - 2; i++) {
                super.array[i] = super.array[i + 1];
            }
            return res;
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
