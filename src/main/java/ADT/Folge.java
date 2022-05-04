package ADT;

public interface Folge <T> extends Puffer<T> {
    T get(int pos);
    boolean set(int pos, T e);
    boolean insert(int pos, T e);
    T remove(int pos);
    boolean insert(T e) throws UnsupportedOperationException;
    boolean remove() throws UnsupportedOperationException;
}
