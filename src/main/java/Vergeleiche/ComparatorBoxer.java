package Vergeleiche;

import java.util.Comparator;

public class ComparatorBoxer implements Comparator<Boxer> {
    @Override
    public int compare(Boxer o1, Boxer o2) {
        int i = o1.getGewicht();
        int j = o2.getGewicht();
        if(i == j){
            return 0;
        }
        else if(i > j){
            return 1;
        }
        else {
            return -1;
        }
    }
}
