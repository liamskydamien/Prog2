package ADT;

public interface Puffer<T> {
    boolean insert(T e);
    boolean remove();
    int size();
    boolean isEmpty();
}
