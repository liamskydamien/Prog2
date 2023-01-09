package ProgrammierÜbungen;
import VerketteteListe.RDVL;

public class JosephusProblem {
    public static int loese(int n, int k){
        RDVL<Integer> speicher = new RDVL<>();
        builtRing(n, speicher);
        speicher.next();
        return josephus(k,speicher);
    }

    private static void builtRing(int n, RDVL<Integer> speicher){
        for (int i = 1; i <= n; i++) {
            speicher.add(i);
        }
    }

    private static int josephus(int k, RDVL<Integer> speicher){
        for (int i = 1; i < k; i++){
            speicher.next();
        }
        int value = speicher.remove();
        if(speicher.isEmpty()){
            return value;
        }
        else {
            return josephus(k, speicher);
        }
    }
}

