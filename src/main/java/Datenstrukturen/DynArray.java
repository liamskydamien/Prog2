package Datenstrukturen;

public class DynArray <T>{
    T[] array;
    int size = 0;

    public DynArray(){
        array = (T[]) new Object[1];
    }

    private T[] CreateArray(int newSize){
        return (T[]) new Object[newSize];
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return array.length;
    }

    public T get(int pos){
        if(pos >= 0 & pos <= size-1){
            return array[pos] != null? array[pos]: null;
        }
        return null;
    }

    public T set(int pos, T e){
        if(get(pos) != null){
            T old = array[pos];
            array[pos] = e;
            return old;
        }
        return null;
    }

    public void addFirst(T e){
        T[] help;
        if(size == capacity()){
            help = CreateArray(capacity()*2);
        }
        else {
            help = CreateArray(capacity());
        }
        help[0] = e;
        for(int i = 0; i < size; i++){
            help[i+1] = array[i];
        }
        array = help;
        size++;
    }

    public void addLast(T e){
        if(size == capacity()){
            T[] help = CreateArray(capacity()*2);
            for(int i = 0; i < size ; i++){
                help[i] = array[i];
            }
            help[size] = e;
            array = help;
        }
        else{
            array[size] = e;
        }
        size++;
    }

    public T removeFirst(){
        T result = array[0];
        T[] help;
        if(capacity() / 4 >= size-1){
            help = CreateArray(capacity()/2);
        }
        else {
            help = CreateArray(capacity());
        }
        for(int i = 0; i < size - 1; i++){
            help[i] = array[i+1];
        }
        array = help;
        size--;
        return result;
    }

    public T removeLast(){
        T result = array[size-1];
        T[] help;
        if(capacity() / 4 >= size-1){
            help = CreateArray(capacity()/2);
        }
        else {
            help = CreateArray(capacity());
        }
        for(int i = 0; i < size - 1; i++){
            help[i] = array[i];
        }
        array = help;
        size--;
        return result;
    }


}
