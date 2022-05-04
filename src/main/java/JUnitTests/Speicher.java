package JUnitTests;

import java.util.NoSuchElementException;

public interface Speicher {
    public  boolean isEmpty();
    public  int size();
    public  int capacitiy();
    public  void push(int pEingabe) throws IllegalStateException;
    public  Integer pop() throws NoSuchElementException;
}
