package IteratorIterable;

import java.util.Iterator;

public class Iterator1DArray <T> implements Iterator<T> {
    private T[] array;
    private int ende;
    private int i;


    public Iterator1DArray(T[] array){
        i = 0;
        this.array = array;
        ende = array.length;
    }

    public Iterator1DArray(T[] array, int start){
        this(array);
        this.i = start;
    }

    public Iterator1DArray(T[] array, int start, int ende){
        this(array, start);
        this.ende = ende -1;
    }


    @Override
    public boolean hasNext() {
        return i < ende;
    }

    @Override
    public T next() {
        return array[i++];
    }
}
