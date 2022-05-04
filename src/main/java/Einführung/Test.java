package Einführung;

public class Test {
    public static void main(String[] args){
        Fifo Fifo1 = new Fifo(5);
        Lifo Lifo1 = new Lifo(5);

        Fifo Fifo2 = new Fifo();
        Lifo Lifo2 = new Lifo();
        while (Fifo2.size() == 3 | Fifo2.size() == 100){
            Fifo2 = new Fifo();
        }

        System.out.println(Fifo2.capacity());
        System.out.println(Lifo2.capacity());

        Integer[] a = {1,2,3,4,5,6};
        for (Integer i: a) {
            Fifo1.push(i);
        }
        for (Integer i: a) {
            Lifo1.push(i);
        }
        System.out.print("Fifo: ");
        for(int i = 0; i < 5; i++){
            System.out.print(Fifo1.pop());
        }
        System.out.println();

        System.out.print("Lifo: ");
        for(int i = 0; i < 5; i++){
            System.out.print(Lifo1.pop());
        }
    }
}
