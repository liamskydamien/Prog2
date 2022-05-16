package Vergeleiche;

public abstract class Person {
    private String vName;   //Vorname der Person
    private String nName;   //Nachname der Person

    public Person(String vName, String nName){
        this.vName = vName; //Setzt Vor- und Nachnamen der Person.
        this.nName = nName;
    }

    public String getVorname() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public String toString(){
        return vName +", "+ nName;
    }
}
