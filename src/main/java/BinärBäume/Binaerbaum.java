package BinärBäume;

public class Binaerbaum <T>{
   private T wurzel;
   private Binaerbaum<T> links;
   private Binaerbaum<T> rechts;

    public Binaerbaum(){
        wurzel = null;
        links = null;
        rechts = null;
    }

    public Binaerbaum(T pW, Binaerbaum pL, Binaerbaum pR){
        if(pW == null){
            wurzel = null;
            links = null;
            rechts = null;
        }
        else {
            wurzel = pW;
        }
        if(pL == null){
            links = new Binaerbaum<>();
        }
        else {
            links = pL;
        }
        if(pR == null){
            rechts = new Binaerbaum<>();
        }
        else {
            rechts = pR;
        }
    }

    public boolean isEmpty(){
        return wurzel == null? true : false;
    }

    public T get(){
        return wurzel;
    }

    public void set(T e){
        wurzel = e;
    }

    public Binaerbaum getLeft(){
        return links;
    }

    public Binaerbaum getRight(){
        return rechts;
    }

    public int hoehe(){
        if(wurzel != null) {
            return 1 + Math.max(hoeheRek(links), hoeheRek(rechts));
        }
        else {
            return 0;
        }
    }

    private int hoeheRek(Binaerbaum e){
        if(!e.isEmpty()){
            return 1 + Math.max(hoeheRek(e.links), hoeheRek(e.rechts));
        }
        else{
            return 0;
        }
    }

    public int size(){
        if(wurzel != null) {
            return 1 + sizeRek(links) + sizeRek(rechts);
        }
        else {
            return 0;
        }
    }

    private int sizeRek(Binaerbaum e){
        if(e.isEmpty()){
            return 0;
        }
        else {
            return 1 + sizeRek(e.links) + sizeRek(e.rechts);
        }
    }

    public String toString(){
        return toStringRek(links) + "<" + wurzel + ">" + toStringRek(rechts);
    }

    public String toStringRek(Binaerbaum e){
        if(e.isEmpty()){
            return "";
        }
        else{
            return toStringRek(e.links) + "<" + e.wurzel + ">" + toStringRek(e.rechts);
        }
    }

    public String preOrder(){
        String out = wurzel + " , " + preOrderRek(links)  + preOrderRek(rechts);
        System.out.println(out);
        return out;
    }

    private String preOrderRek(Binaerbaum pBaum){
        if(pBaum.isEmpty()){
            return "";
        }
        else{
            return pBaum.wurzel + " , " + preOrderRek(pBaum.links) + preOrderRek(pBaum.rechts);
        }
    }

    public String inOrder(){
        String out = inOrderRek(links) + wurzel +" , " + inOrderRek(rechts);
        System.out.println(out);
        return out;
    }

    private String inOrderRek(Binaerbaum pBaum){
        if(pBaum.isEmpty()){
            return "";
        }
        else{
            return  inOrderRek(pBaum.links) + pBaum.wurzel + " , "+ inOrderRek(pBaum.rechts);
        }
    }

    public String postOrder(){
        String out = postOrderRek(links) + postOrderRek(rechts) + wurzel;
        System.out.println(out);
        return out;
    }

    private String postOrderRek(Binaerbaum pBaum){
        if(pBaum.isEmpty()){
            return "";
        }
        else{
            return  postOrderRek(pBaum.links)  + postOrderRek(pBaum.rechts) + pBaum.wurzel + " , ";
        }
    }



}
