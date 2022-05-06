package Generics1;

import java.util.NoSuchElementException;

public interface KellerspeicherG <T> extends SpeicherG<T>{
    T top() throws NoSuchElementException;
}
