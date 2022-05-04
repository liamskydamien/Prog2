package Datenstrukturen;
// Disclaimer: Ringpuffer ist derzeit noch Fehlerhaft.
public class RingPuffer <T>{
    int size = 0;
    int first = 0;
    int last = 0;
    T[] array;

    public RingPuffer(int capacity){
        array = (T[]) new Object[capacity];
    }

    private int capacity(){
        return array.length;
    }


    public T get(int pos) throws IndexOutOfBoundsException{
        if(pos >= 0 & pos < size){
            return array[pos];
        }
        else {
            throw new IndexOutOfBoundsException("Position befindet sich außerhalb der belegten Plätze.");
        }
    }

    public int size(){
        return size;
    }

    public void set(int pos, T e) {
        if(pos >= 0 & pos < size & e != null){
            array[pos] = e;
        }
        else if (e == null){
            System.out.println("Eingesetztes Element gleich null");
            return;
        }
        else {
            System.out.println("Index out of Bounds bei set()");
            return;
        }
    }
    public T getFirst(){
        return array[first];
    }

    public T getPos(int pos){
        return array[pos];
    }

    public void insert(T e){
        if(last == capacity()){
            last = 0;
        }
        array[last+1] = e;
        last++;
        size++;
    }

    public T remove(){
        first++;
        return array[first -1];
    }

    public void addFirst(T e){
        if(getFirst() != null){
            if(first >= 1 & array[first-1] == null){
                set(first-1, e);
                first--;
                size++;
            } else if (first == 0 & array[last] == null) {
                set(last, e);
                first = last;
                last--;
                size++;
            }
            else{
                set(first, e);
            }
        }
            else{
                set(first,e);
            }
        }

    public void addLast(T e){
        if(get(last) != null){
            if(last+1 >= capacity()){

            }
        }
        else{
            set(last, e);
        }
    }

    public T removeLast(){
        T place = array[size-1];
        array[size-1] = null;
        size--;
        return place;
    }

    public T removeFirst(){
        T place = array[first];
        array[first] = null;
        first++;
        if(first == capacity()){
            first = 0;
        }
        return place;
    }

}
