package BinaerBaeume;

import java.util.NoSuchElementException;

public class Suchbaum extends Binaerbaum<Integer>{
    public Suchbaum(){
        super();
    }

    public Suchbaum(int e){
        super(e, null, null);
    }

    public boolean contains(int e){
        if(super.get() == e){
            return true;
        }
        else{
            return super.get() < e ? containsRek(e, super.getLeft()) : containsRek(e, super.getRight());
        }
    }

    private boolean containsRek(int e, Binaerbaum<Integer> p){
        if(p.get() == e){
            return true;
        }
        else {
            if(p.isEmpty()){
                return false;
            }
            else {
                return p.get() < e ? containsRek(e, p.getLeft()) : containsRek(e, getRight());
            }
        }

    }

    public void insert(int e) throws IllegalArgumentException{
        if(contains(e)){
            throw new IllegalArgumentException("Wert bereits in Suchbaum.");
        }
        else {
            if(super.get() == null){
                super.set(e);
            }
            else{
                if(super.get() < e){
                    insertRek(e, super.getLeft());
                }
                else{
                    insertRek(e, super.getRight());
                }
            }
        }
    }

    private void insertRek(int e, Binaerbaum<Integer> baum){
        if(baum.isEmpty()){
            baum.set(e);
        }
        else {
            if(baum.get() < e){
                insertRek(e, baum.getLeft());
            }
            else {
                insertRek(e, baum.getRight());
            }
        }
    }

    public void remove(int e) throws NoSuchElementException {
        if(!contains(e)){
            throw new NoSuchElementException();
        }
        else {

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
