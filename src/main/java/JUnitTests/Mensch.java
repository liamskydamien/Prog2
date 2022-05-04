package JUnitTests;

public abstract class Mensch {
    private String vName;
    private String nName;

    public Mensch(String pvName,String pnName){
        vName = pvName;
        nName = pnName;
    }
    public String getName(){
        return nName;
    }

    public String getVName(){
        return vName;
    }

    public String toString(){
        return vName + " , " + nName;
    }
}
