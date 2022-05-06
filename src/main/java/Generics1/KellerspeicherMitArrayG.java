package Generics1;


import java.util.NoSuchElementException;

public class KellerspeicherMitArrayG <T> implements KellerspeicherG <T>{
    private  T[] f;
    private int size = 0;

    public KellerspeicherMitArrayG(int maxGroesse){
      /**  @SuppressWarnings("unchecked")
        final T[] f = (T[]) Array.newInstance(c, maxGroesse);
        this.f = f; */
      f = (T[])new Object[maxGroesse];
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

    public T top() throws NoSuchElementException {
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

    public void push(T pEingabe) throws IllegalStateException {
        try{
            f[size++] = pEingabe;
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new IllegalStateException();
        }
    }

    public T pop() throws NoSuchElementException {
        try {
            return f[--size];
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new NoSuchElementException();
        }
    }
}
