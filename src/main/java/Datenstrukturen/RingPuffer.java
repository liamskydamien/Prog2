package Datenstrukturen;
public class RingPuffer<T> {
    int size = 0; // Anzahl der belegeten Plätze
    int capazity;
    int front= 0;
    int back= 0;
    T[] array;
    @SuppressWarnings("unchecked")
    public RingPuffer(int capazity){
        this.capazity = capazity;
        array = (T[]) new Object[capazity];
    }
    public boolean isEmpty(){return size == 0? true: false;}
    public int size(){return size;}
    public T get(int pos){
        try {
            return array[pos];
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException();
        }
        catch (NullPointerException e){
            throw new NullPointerException();
        }
    }
    public T set(int pos, T e){
        try {
            T data = array[pos];
            array[pos] = null;
            return data;
        }catch (ArrayIndexOutOfBoundsException a){
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public void addFirst(T e){
        if(size == capazity){
            throw new ArrayIndexOutOfBoundsException();
        }
        try {
            if(isEmpty()){
                array[0] = e;
                ++size;
            }
            else{
                array[front - 1] = e;
                front = front - 1;
                ++size;
            }
        }catch (ArrayIndexOutOfBoundsException a){
            array[capazity-1] = e;
            front = capazity-1;
            ++size;
        }
    }
    public void addLast(T e){
        if(size == capazity){ // ist es voll?
            throw new ArrayIndexOutOfBoundsException();
        }
        try {
            if (isEmpty()) { // Einfügen des ersten Elements
                array[0] = e;
                ++size;
            }else { // Einfügen von weiteren Elementen
                array[++back] = e; // ++back -> back wird zuerst erhöht, dann er Zugriff
                ++size;
            }
        }catch (ArrayIndexOutOfBoundsException a){ // Falls ++back größer als die eigentliche Kapazität ist
            array[0] = e; // "Kreis schließen
            back = 0;
            ++size;
        }

    }
    public T removeFirst(){
        T data = array[front]; // Daten speichern
        array[front] = null; // erstes Element löschen
        front = front+1; // front zeiger auf das nächste element
        if(front > capazity-1){// überprüfen ob front größer als die Kapazität ist
            front = 0; // wenn ja wird front auf null gesetzt -> Kreis schließen
        }
        --size;
        return data;
    }
    public T removeLast(){
        T data = array[back];
        array[back] = null;
        back = back-1;
        if(back == -1){ // überprüfen auf back vorher auf die 0. Position gezeigt hat
            back = 3; // wenn ja , dann ist das nähste back 3
        }
        --size;
        return data;
    }
}

