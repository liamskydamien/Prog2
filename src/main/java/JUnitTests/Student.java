package JUnitTests;

public class Student extends Mensch{
    private Integer pMatrikel;
    public Student(String pVName, String pNName, int pMat){
        super(pVName,pNName);
        pMatrikel = pMat;
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
        return super.toString() + " , " + pMatrikel;
    }

    public Integer getpMatrikel() {
        return pMatrikel;
    }

    public boolean equals(Object o) {
        return (o instanceof Student && this.pMatrikel == ((Student)o).pMatrikel);
    }
}
