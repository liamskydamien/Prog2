package BinärBäume;

import java.util.NoSuchElementException;

public class Suchbaum extends Binaerbaum<Integer>{
    public Suchbaum(){
        super();
    }

    public Suchbaum(int e){
        super(e, null, null);
    }

    public boolean contains(int e){
        if(super.isEmpty()){
            return false;
        }
        else if(super.get() == e){
            return true;
        }
        else{
            if((super.getLeft() == null || super.getLeft().isEmpty()) & super.get() > e){
                return false;
            }
            else if((super.getRight() == null || super.getRight().isEmpty()) & super.get() < e){
                return false;
            }
            return super.get() > e ? containsRek(e, super.getLeft()) : containsRek(e, super.getRight());
        }
    }

    private boolean containsRek(int e, Binaerbaum<Integer> p){
        if(p == null || p.isEmpty()){
            return false;
        }
        else {
            if(p.get() == e){
                return true;
            }
            else {
                if(p.getLeft().isEmpty() & super.get() < e){
                    return false;
                }
                else if(p.getRight().isEmpty() & super.get() > e){
                    return false;
                }
                return p.get() > e ? containsRek(e, p.getLeft()) : containsRek(e, getRight());
            }
        }

    }

    public void insert(int e) throws IllegalArgumentException{
        if(contains(e)){
            throw new IllegalArgumentException("Wert bereits in Suchbaum.");
        }
        else {
            if(super.isEmpty()){
                super.set(e);
            }
            else{
                if(super.get() > e & super.getLeft() != null){
                    insertRek(e, super.getLeft());
                }
                else if(super.get() < e & super.getRight() != null){
                    insertRek(e, super.getRight());
                } else if(super.get() > e & super.getLeft() == null){
                    super.setLeft(new Binaerbaum(e, null, null));
                }
                else if(super.get() < e & super.getRight() == null){
                    super.setRight(new Binaerbaum(e, null, null));
                }
            }
        }
    }

    private void insertRek(int e, Binaerbaum<Integer> baum){
        if(baum.isEmpty()){
            baum.set(e);
        }
        else {
            if(baum.get() > e & baum.getLeft() != null){
                insertRek(e, baum.getLeft());
            }
            else if(baum.get() < e & baum.getRight() != null){
                insertRek(e, baum.getRight());
            }
            else if(baum.get() > e & baum.getLeft() == null){
                baum.setLeft(new Binaerbaum(e, null, null));
            }
            else if(baum.get() < e & baum.getRight() == null){
                baum.setRight(new Binaerbaum(e, null, null));
            }
        }
    }

    public void remove(int e) throws NoSuchElementException {
        if(!contains(e)){
            throw new NoSuchElementException();
        }
        else {
            if(e >= super.get()){
                removeRek(e,super.getRight());
            }
            else {
                removeRek(e, super.getLeft());
            }
        }
    }

    private void removeRek(int e, Binaerbaum<Integer> baum){
        if(baum.get() == e) {
            if(baum.getLeft().isEmpty() & baum.getRight().isEmpty()){
                baum.set(null);
            }
            else if(!baum.getLeft().isEmpty() & baum.getRight().isEmpty()){
                Binaerbaum<Integer> save = baum.getLeft();
                remove(save.get());
                baum.set(save.get());
            } else if(baum.getLeft().isEmpty() & !baum.getRight().isEmpty()){
                Binaerbaum<Integer> save = baum.getRight();
                remove(save.get());
                baum.set(save.get());
            }
            else{
                Binaerbaum<Integer> save = getHighest(baum);
                remove(save.get());
                baum.set(save.get());
            }
        }
        else{
            if(e > baum.get()){
                removeRek(e, baum.getRight());
            }
            else{
                removeRek(e, baum.getLeft());
            }
        }
    }

    public Binaerbaum getHighest(Binaerbaum<Integer> e){
        if(e.getRight().isEmpty()){
            return e;
        }
        return getHighestRek(e.getRight(), e);
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
