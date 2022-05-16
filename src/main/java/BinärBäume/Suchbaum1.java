package BinärBäume;


import java.util.NoSuchElementException;

public class Suchbaum1 extends Binaerbaum<Integer>{
    public Suchbaum1(){
        super(null,null,null);
    }

    public Suchbaum1(int e){
        super(e,null,null);
    }

    public boolean contains(int e){
        if(super.isEmpty()){
            return false;
        }
        else {
            if(super.get() == e){
                return true;
            }
            else if(super.get() > e){
                return containsRek(super.getLeft(), e);
            }
            else if(super.get() < e) {
                return containsRek(super.getRight(), e);
            }
            else{
                return false;
            }
        }
    }

    private boolean containsRek(Binaerbaum<Integer> b, int e) {
        if (b != null) {
            if (b.isEmpty()) {
                return false;
            } else {
                if (b.get() == e) {
                    return true;
                } else if (b.get() > e) {
                    return containsRek(b.getLeft(), e);
                } else if (b.get() < e) {
                    return containsRek(b.getRight(), e);
                } else {
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }

    public void insert(int e){
        if(contains(e)){
            throw new IllegalArgumentException();
        }

        if(super.isEmpty()){
            super.set(e);
        }
        else{
            if(super.getLeft() == null & super.getRight() == null){
                    super.setLeft(new Binaerbaum<Integer>(null,null,null));
                    super.setRight(new Binaerbaum<Integer>(null,null,null));
            }
            if(super.get() > e ){
                insertRek(super.getLeft(), e);
            }
            else{
                insertRek(super.getRight(),e);
            }
        }
    }

    private void insertRek(Binaerbaum<Integer> b, int e){
        if(b != null) {
            if (b.isEmpty()) {
                b.set(e);
                b.setRight(new Binaerbaum<Integer>(null,null,null));
                b.setLeft(new Binaerbaum<Integer>(null,null,null));
            }
            else {
                if(b.get() > e){
                    insertRek(b.getLeft(), e);
                }
                else {
                    insertRek(b.getRight(), e);
                }
            }
        }
    }

    public void remove(int e){
        if(!contains(e)){
            throw new NoSuchElementException();
        }
        if(super.get() == e){
            if(super.getLeft().isEmpty() & super.getRight().isEmpty()){
                super.set(null);
            }
            else{
                super.set(null);
            }
            }
        }


    private void swap(Binaerbaum<Integer> a, Binaerbaum<Integer> b){
        if(a.get() != null & b.get() != null) {
            int aw = a.get();
            a.set(b.get());
            b.set(aw);
        }
        else {
            a.set(b.get());
        }
            if (a.get1() > (int) a.getRight().get()) {
                swap(a, a.getRight());
            } else if (a.get1() < (int) a.getLeft().get()) {
                swap(a, a.getLeft());
            }

            if (b.get1() > (int) b.getRight().get()) {
                swap(b, b.getLeft());
            } else if (b.get1() < (int) b.getLeft().get()) {
                swap(b, b.getLeft());
            }
        }

    public Binaerbaum getHighest(Binaerbaum<Integer> e){
        if(e != null){
            if(e.getRight().isEmpty()){
                return e;
            }
            else{
                return getHighest(e.getRight());
            }
        }
        else {
            return null;
        }
    }

    private Binaerbaum getHighestRek(Binaerbaum<Integer> e, Binaerbaum<Integer> current){
        if(e.isEmpty()){
            return current;
        }
        else{
            if((int) e.getLeft().get() > current.get()){
                return getHighestRek(e.getLeft().getRight(), e.getLeft());
            } else if ((int) e.getRight().get() > current.get()){
                return getHighestRek(e.getRight().getRight(), e.getRight());
            }
            else if((int) e.get() > current.get()){
                return e;
            }
            else {
                return current;
            }
        }
    }
}
