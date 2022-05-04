package JUnitTests;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class KellerspeicherMitArray implements Kellerspeicher{
    private  Integer[] f;
    private int size = 0;

    public KellerspeicherMitArray(int maxGroesse){
        f = new Integer[maxGroesse];
    }

    public boolean isEmpty() {
        if(f[0] == null){
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public int capacitiy() {
        return f.length;
    }

    public int top() throws NoSuchElementException {
        try {
            int s = size -1;
            if (f[s] == null) {
                throw new NoSuchElementException();
            } else {
                return f[s];
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
    }

    public void push(int pEingabe) throws IllegalStateException {
        try{
            f[size++] = pEingabe;
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new IllegalStateException();
        }
    }

    public Integer pop() throws NoSuchElementException {
        try {
            return f[--size];
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
    }
}
