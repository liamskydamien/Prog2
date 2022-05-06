package Generics1;

public class Paar <T,E>{
    private T kT = null;
    private E kE = null;

    public void setErstes(T pT){
        kT = pT;
    }

    public void setZweites(E pE){
        kE = pE;
    }

    public T getErstes(){
        return kT;
    }

    public E getZweites(){
        return kE;
    }

    public void setBeide(T pT, E pE){
        kT = pT;
        kE = pE;
    }

    public boolean equals(Paar <T, E> p){
        if(p == this){
            return true;
        }
        else if(p.getErstes() == getErstes() && p.getZweites() == getZweites()){
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        return "(" + getErstes() + " , " + getZweites() + ")";
    }

}
