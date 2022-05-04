package JUnitTests;

import java.util.NoSuchElementException;

public class WarteschlangeMitArray implements Warteschlange{
    private Integer[] f;
    private int size = 0;

    public WarteschlangeMitArray(int maxGroesse){
        f = new Integer[maxGroesse];
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
    public int front() throws NoSuchElementException {
        if(f[0] == null){
            throw new NoSuchElementException();
        }
        else {
            return f[0];
        }
    }

    @Override
    public void push(int pEingabe) throws IllegalStateException {
        try{
            f[size++] = pEingabe;
        }
        catch (Exception e){
            throw new IllegalStateException();
        }
    }

    @Override
    public  Integer pop() throws NoSuchElementException {
        try {
            if(isEmpty()){
                throw new NoSuchElementException();
            }
            int res = f[0];
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