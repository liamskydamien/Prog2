package Vergeleiche;

public class Student extends Person implements Comparable<Student>{
    private int matNr; //Matrikelnummer des Studenten

    public Student(String vName, String nName, int matNr){
        super(vName, nName); //legt eine neue Person mit übergebenen Namen an
        this.matNr = matNr; //bestimmt MAtrikelnummer
    }
    public int getMatNr(){
        return matNr;
    }

    public String toString(){
        return super.toString() + ", " + matNr;
    }

    public boolean equals(Student o){
        return this.compareTo(o) == 0? true : false;
    }

    @Override
    public int compareTo(Student o) {
        if(o != null){                      //Es wird überprüft ob der übergebene Student != null ist
            int oMat = o.getMatNr();        //Speichert die MatNr des übergebenen Studenten
            int tMat = this.getMatNr();     //Speichert die MatNr des Studenten
            if(oMat == tMat){
                return 0;                   //Falls Student A und Student B die selbe Nummer haben wird 0 ausgegeben.
            }
            else if(oMat > tMat) {
                return -1;                  //Falls die Nummer von B größer ist als A wird -1 ausgeben
            }
            else {
                return 1;                   //Falls die Nummer von A größer als B ist wird 1 ausgegeben
            }
        }
        else {
            return 1;                        //Falls statt einem gültigen Studenten null übergeben wurde ist A größer daher wird 1 ausgeben.
        }
    }
}
