package Vergeleiche;

import java.util.Comparator;

public class ComparatorPerson implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        String vName1 = o1.getVorname();
        String vName2 = o2.getVorname();
        String nName1 = o1.getName();
        String nName2 = o2.getName();
        int i = vName1.compareTo(vName2);
        if (i == 0){
            int j = nName1.compareTo(nName2);
            if(j == 0){
                return 0;
            }
            else{
                return j;
            }
        }
        else {
            return i;
        }
    }
}
