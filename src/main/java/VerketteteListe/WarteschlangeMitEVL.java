package VerketteteListe;

import Generics1.WarteschlangeG;

import java.util.NoSuchElementException;

public class WarteschlangeMitEVL<T> implements WarteschlangeG<T> {
    EVL<T> warteschlange;
    public WarteschlangeMitEVL(){
        warteschlange = new EVL<T>();
    }

    @Override
    public T pop() throws NoSuchElementException {
        if(!warteschlange.isEmpty()) {
            T data = (T) warteschlange.getFirst().getData();
            warteschlange.removeFirst();
            return data;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void push(T p) throws NoSuchElementException {
        warteschlange.addLast(p);
    }

    @Override
    public int size() {
        return warteschlange.size();
    }

    @Override
    public int capacitiy() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isEmpty() {
        return warteschlange.isEmpty();
    }

    @Override
    public T front() throws NoSuchElementException {
        if(!warteschlange.isEmpty()){
        return (T) warteschlange.getFirst().getData();
        }
        else{
            throw new NoSuchElementException();
        }
    }

}
