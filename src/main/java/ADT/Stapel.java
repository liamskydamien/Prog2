package ADT;

public interface Stapel <T> extends Folge<T>{
    T top();
    @Override
    boolean insert(T e);
    @Override
    boolean remove();
}
