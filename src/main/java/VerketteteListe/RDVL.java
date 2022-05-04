package VerketteteListe;

public class RDVL<T>{
    EVLUnit entry;
    int size = 0;
    public RDVL(){
        entry = null;
    }
    public class EVLUnit <T>{
       T vData = null;
       EVLUnit next;
       EVLUnit previous;

       public EVLUnit(T o){
        vData = o;
        next = null;
        previous = null;
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

       public EVLUnit getPrevious(){return this.previous;}

       public void setPrevious(EVLUnit o){
           this.previous = o;
           o.setNext(this);
        }

       public T getData(){
           return vData;
       }
    }

    public T element(){
        if(!isEmpty()){
            return (T) entry.getData();
        }
        return null;
    }
    public void add(T o){
        EVLUnit <T> pUnit = new EVLUnit<T>(o);
        if (entry != null) {
            if(entry.getPrevious() != null & entry.getNext() != null){
            pUnit.setNext(entry.getNext());
            pUnit.setPrevious(entry);
            entry.setNext(pUnit);
            entry = pUnit;
        }
            else {
                pUnit.setNext(entry);
                pUnit.setPrevious(entry);
                entry.setPrevious(pUnit);
                entry.setNext(pUnit);
                entry = pUnit;
            }
        }
        else {
            entry = pUnit;
        }
        size++;
    }

    public T remove(){
        if(entry == null){
            return null;
        }
        else if( entry.getNext() != entry){
            EVLUnit data = entry;
            entry = entry.getNext();
            data.getPrevious().setNext(entry);
            entry.setPrevious(data.getPrevious());
            size--;
            return (T) data.getData();
        }
        else{
            EVLUnit data = entry;
            entry = null;
            return (T) data.getData();
        }
    }

    public void next(){
        entry = entry.getNext();
    }

    public void prev(){
        entry = entry.getPrevious();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return entry == null ? true : false;
    }

    }

