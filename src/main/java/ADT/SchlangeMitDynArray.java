package ADT;

import Datenstrukturen.DynArray;

public class SchlangeMitDynArray <T> implements Schlange<T>{
    DynArray<T> array;
    public SchlangeMitDynArray(){
        array = new DynArray<T>();
    }

    @Override
    public boolean insert(T e) {
        array.addFirst(e);
        return true;
    }

    @Override
    public boolean remove() {
        array.removeLast();
        return true;
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.size() == 0? true : false;
    }

    @Override
    public T first() {
        if(!isEmpty()) {
            return array.get(0);
        }
        else {
            return null;
        }
    }
}
