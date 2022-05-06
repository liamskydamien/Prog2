package Generics1;
import java.util.NoSuchElementException;

public interface WarteschlangeG <T> extends SpeicherG <T>{
        public T front() throws NoSuchElementException;
    }
