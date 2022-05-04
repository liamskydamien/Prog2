package JUnitTests;

import javax.swing.*;

public class Boxer extends Mensch{
    private Integer pGewicht;
    public Boxer(String pVName, String pNName, int pGew){
        super(pVName,pNName);
        pGewicht = pGew;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getVName() {
        return super.getVName();
    }

    @Override
    public String toString() {
        return super.toString() + " , " + pGewicht;
    }

    public Integer getpGewicht() {
        return pGewicht;
    }

    public boolean equals(Object o) {
        return (o instanceof Boxer && this.pGewicht == ((Boxer)o).pGewicht);
    }
}
