package Generics1;

import java.util.NoSuchElementException;

public class WarteschlangeMitArrayG <T> implements WarteschlangeG <T>{
    private T[] f;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public WarteschlangeMitArrayG(int maxGroesse){
        f = (T[]) new Object[maxGroesse];
    }

    @Override
    public boolean isEmpty() {
        if(f[0] == null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacitiy() {
        return f.length;
    }

    @Override
    public T front() throws NoSuchElementException {
        if(f[0] == null){
            throw new NoSuchElementException();
        }
        else {
            return f[0];
        }
    }

    @Override
    public void push(T pEingabe) throws IllegalStateException {
        try{
            f[size++] = pEingabe;
        }
        catch (Exception e){
            throw new IllegalStateException();
        }
    }

    @Override
    public  T pop() throws NoSuchElementException {
        try {
            if(isEmpty()){
                throw new NoSuchElementException();
            }
            T res = f[0];
            f[0] = null;
            for (int i = 0; i <= size - 2; i++) {
                f[i] = f[i + 1];
            }
            size--;
            return res;
        }
        catch (Exception e){
            throw new NoSuchElementException();
        }
    }
}
