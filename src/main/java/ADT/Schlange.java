package ADT;

public interface Schlange <T> extends Puffer<T>{
    T first();
    @Override
    boolean insert(T e);
    @Override
    boolean remove();
}
