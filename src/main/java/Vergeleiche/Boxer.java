package Vergeleiche;

public class Boxer extends Person implements Comparable<Boxer>{
    private int gewicht;

    public Boxer(String vName, String nName, int gewicht){
        super(vName,nName);
        this.gewicht = gewicht;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public boolean equals(Boxer o){
       return this.compareTo(o) == 0? true : false;
    }

    @Override
    public int compareTo(Boxer o) {
        if(o != null){
            if(o.getGewicht() == this.getGewicht()) {
                if (o.getName() == this.getName()) {
                    int vN = this.getVorname().compareTo(o.getVorname());
                    return vN;
                } else {
                    int nN = this.getName().compareTo(o.getName());
                    return nN;
                }
            }
        else {
            if(this.getGewicht() < o.getGewicht()){
                return -1;
            }
            else {
                return 1;
            }
        }
    }
        else {
            return 1;
        }
    }
}
