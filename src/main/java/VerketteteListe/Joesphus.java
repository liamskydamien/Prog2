package VerketteteListe;

public class Joesphus {
    public static int loese(int n, int k){
        RDVL<Integer> kreis = new RDVL<Integer>();
        for(int i = 1; i <= n; i++){
            kreis.add(i);
        }
        return helper(kreis, k);
    }

    private static int helper(RDVL kreis, int k){
        for(int i = 0; i < k; i++){
            kreis.next();
        }
        int value = (int) kreis.element();
        kreis.remove();
        if(kreis.isEmpty()){
            return value;
        }
        else{
            return 0 + helper(kreis, k);
        }
    }
}
