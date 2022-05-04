package VerketteteListe;

public class EVL<T>{
    EVLUnit first;
    int size = 0;
    public EVL(){
        first = null;
    }
    public class EVLUnit <T>{
       T vData = null;
       EVLUnit next;

       public EVLUnit(T o){
        vData = o;
        next = null;
       }

       public boolean isEmtpty(){
           return vData == null ? true : false;
       }

       public EVLUnit getNext(){
           return this.next;
       }

       public void setNext(EVLUnit pNext){
           this.next = pNext;
       }

       public T getData(){
           return vData;
       }
    }

    public void addFirst(T o){
        EVLUnit <T> pUnit = new EVLUnit<T>(o);
        if (first != null) {
            pUnit.setNext(first);
        }
        first = pUnit;
        size++;
    }

    public EVLUnit removeFirst(){
        if(first.getNext() == null){
            EVLUnit puffer = first;
            first = null;
            size--;
            return puffer;
        }
        else {
            EVLUnit puffer = first;
            first = first.getNext();
            size--;
            return puffer;
        }
    }

    public int size(){
        return size;
    }

    public boolean contains(T pUnit){
        if(!isEmpty()){
            EVLUnit current = first;
            while (current.getNext() != null){
                if(current.getData() == pUnit){
                    return true;
                }
                else {
                    current = current.getNext();
                }
            }
            return false;
        }
        else {
            return false;
        }
    }

    public EVLUnit getFirst(){
        return first;
    }

    public EVLUnit getLast() {
        if (!isEmpty()) {
            EVLUnit pObject = first;
            while (pObject.getNext() != null) {
                pObject = pObject.getNext();
            }
            return pObject;
        }
        else {
            return null;
        }
    }

    public void addLast(T pAdd){
        EVLUnit <T> vUnit = new EVLUnit<T>(pAdd);
        if(!isEmpty()) {
            getLast().setNext(vUnit);
            size++;
        }
        else {
            first = vUnit;
            size++;
        }
    }

    public void zip(EVL<T> other){
        zipHelper(first, other.first);
        other.first = null; // Da das Fiirst des Others auf null gesetzt wurde. Wird der Rest vom Garbage-Collector gelöscht.
    }

    private void zipHelper(EVLUnit pFirst, EVLUnit pOther){
        EVLUnit nextFirst =  pFirst.getNext();
        EVLUnit nextOther = pOther.getNext();

        if(nextFirst != null & nextOther != null){
            pFirst.setNext(pOther);
            pOther.setNext(nextFirst);
            zipHelper(nextFirst, nextOther);
        }
        else if(nextFirst == null & nextOther != null) {
            pFirst.setNext(pOther);
            return;
        }
        else if(nextFirst != null & nextOther == null){
            pFirst.setNext(pOther);
            pOther.setNext(nextFirst);
            return;
        }
        else{
            return;
        }

    }

    public void zip2(EVL<T> other){
        if(other.isEmpty()){
            return;
        }
        else if(isEmpty()){                                     // Falls this leer ist füge die Elemente von other von vorne nach i
            int max = other.size();
            for(int i = 0; i < max; i++){
                addFirst((T)other.removeFirst().getData());
            }
        }
        else {
            EVLUnit start = first;
            EVLUnit next = other.getFirst();
            while (start.getNext() != null) {       // Solange start nicht das letzte Element, durchlaufe die Schleife.
                EVLUnit puffer = start.getNext();   // Speichere das nächste Element  von Start als Puffer
                start.setNext(next);                // Verweise von start auf next
                next = other.removeFirst().getNext(); // Ersetze next durch das nächste Element in other und entferne das erste Element in other.
                start.getNext().setNext(puffer);        // Verweise von ehemals next auf das puffer Element.//
                start = puffer;                     // Ersetze start durch Puffer
                size++;                             // Erhöhe die größe von EVL

            }
            if (!other.isEmpty()) {                 // Wenn other nicht leer ist
                start.setNext(next);                // Füge das letzte next an die "Schlange" an.
                size = size + other.size();         // Addiere die übrige Größe zu size dazu.
                other.first = null;                 // setze other zu null und größe zu 0
                other.size = 0;
            }
        }
    }



    public boolean isEmpty(){
        return first == null ? true : false;
    }

    public EVLUnit removeLast(){
        if(!isEmpty()){
            EVLUnit vUnit = first;
            while (vUnit.getNext() != null){
                if(vUnit.getNext().getNext() == null){
                    EVLUnit puffer = vUnit.getNext();
                    vUnit.setNext(null);
                    size--;
                    return puffer;
                }
                else{
                    vUnit = vUnit.getNext();
                }
            }
            return null;
            }
        else {
            return null;
        }
        }
    }

