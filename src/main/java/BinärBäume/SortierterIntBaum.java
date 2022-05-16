package BinärBäume;

// Klasse SortierterIntBaum
// - Binärbaum
// - für int
// - sortiert

public class SortierterIntBaum {
    Knoten root = null;
    class Knoten{
        int val;
        Knoten ltb, rtb = null;

        Knoten(int v){
            val = v;
        }
    }

    public void add(int v) {
        if(null == root) {
            root = new Knoten(v);
            return;
        }
        insert(v, root);		// rekusives Einfügen
    }

    private void insert(int v, Knoten k) {
        if(this.contains(v)) throw new IllegalArgumentException();
        if(v == k.val) return;

        // fügt v unterhalb von k ein
        if(v < k.val)
            insertLinks(v,k);
        else
            insertRechts(v,k);
    }

    void insertLinks(int v, Knoten k) {
        if(null == k.ltb)
            k.ltb = new Knoten(v);
        else
            insert(v, k.ltb);
    }
    void insertRechts(int v, Knoten k) {
        if(null == k.rtb)
            k.rtb = new Knoten(v);
        else
            insert(v, k.rtb);
    }

	public boolean contains(int v) {
		return(containsIn(v, root));
	}
	boolean containsIn(int v, Knoten k) {
        if (null != k) {
            if (v == k.val) return true;
            if (v < k.val) {
                containsIn(v, k.ltb);
            } else {
                containsIn(v, k.rtb);
            }
        }
        return false;
    }
/**
 * Eigner Versuch:
    public int remov1e(int v){
        if(this.contains(v)){
            if()
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public int removeIn(int v, Knoten k){

    }

    private void swap(Knoten a, Knoten b){
        Knoten ar = a.rtb;
        Knoten al = a.ltb;
        a.rtb = b.rtb;
        a.ltb = b.ltb;
        b.rtb = ar;
        b.ltb = al;
    }

    private void sort(Knoten k){
        if(k.val > k.rtb.val){
            swap(k, k.rtb);

        }
    }

    private Knoten searchForLargest(Knoten k){
        if(k.rtb == null){
            return k;
        }
        else {
            return searchForLargest(k.rtb);
        }
    }
*/
    String toString(Knoten k) {
        String s = "(";
        if(null != k) {
            s += toString(k.ltb);
            s = s + k.val;
            s += toString(k.rtb);
        }
        s += ")";
        return s;
    }

    public String toString() {
        return toString(root);
    }

    /**
     * Aus dem Internet: https://github.com/shivanidwivedi/JavaProgramming/commit/732d5ed122dfc90741e62d85e4e39de1c394052d
     * @param root
     * @param key
     * @return
     */
    public Knoten remove(Knoten root, int key) {
        if(root == null) return root;
        if(key > root.val){
            root.rtb = remove(root.rtb, key);
        }else if(key < root.val){
            root.ltb = remove(root.ltb, key);
        }else{
            if(root.ltb == null && root.rtb == null){
                root = null;
            }else if(root.rtb != null){
                root.val = successor(root);
                root.rtb = remove(root.rtb, root.val);
            }else{
                root.val = predecessor(root);
                root.ltb = remove(root.ltb, root.val);
            }
        }
        return root;
    }

    private int successor(Knoten root){
        root = root.rtb;
        while(root.ltb != null){
            root = root.ltb;
        }
        return root.val;
    }

    private int predecessor(Knoten root){
        root = root.ltb;
        while(root.rtb != null){
            root = root.rtb;
        }
        return root.val;
    }
}

