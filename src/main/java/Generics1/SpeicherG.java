package Generics1;
import java.util.NoSuchElementException;

public interface SpeicherG <T> {
    T pop() throws NoSuchElementException;
    void push(T p) throws NoSuchElementException;
    int size();
    int capacitiy();
    boolean isEmpty();
}
