package Vergeleiche;

import java.util.Comparator;

public class GenericSearchTree<T>{
        Knoten root = null;
        Comparator comparator;
        class Knoten<T>{
            T val;
            Knoten ltb, rtb = null;

            Knoten(T v){
                val = v;
            }
        }

        public GenericSearchTree(Comparator comparator){
            this.comparator = comparator;
        }

        public void add(T v) {
            if(null == root) {
                root = new Knoten(v);
                return;
            }
            insert(v, root);		// rekusives Einfügen
        }

        private void insert(T v, Knoten k) {
            if(this.contains(v)) throw new IllegalArgumentException();
            int comp = comparator.compare(k.val, v);
            if(comp == 0) return;

            // fügt v unterhalb von k ein
            if(comp == 1)
                insertLinks(v,k);
            else
                insertRechts(v,k);
        }

        void insertLinks(T v, Knoten k) {
            if(null == k.ltb)
                k.ltb = new Knoten(v);
            else
                insert(v, k.ltb);
        }
        void insertRechts(T v, Knoten k) {
            if(null == k.rtb)
                k.rtb = new Knoten(v);
            else
                insert(v, k.rtb);
        }

        public boolean contains(T v) {
            return(containsIn(v, root));
        }
        boolean containsIn(T v, Knoten k) {
            if (null != k) {
                int comp = comparator.compare(v, k.val);
                if (comp == 0) return true;
                if (comp == 1) {
                    containsIn(v, k.ltb);
                } else {
                    containsIn(v, k.rtb);
                }
            }
            return false;
        }

        String toString(Knoten k) {
            String s = "(";
            if(null != k) {
                s += toString(k.ltb);
                s = s + k.val.toString();
                s += toString(k.rtb);
            }
            s += ")";
            return s;
        }

        public String toString() {
            return toString(root);
        }

        public Knoten remove(Knoten root, T key) {
            if(root == null) return root;
            int comp = comparator.compare(key, root.val);
            if(comp == 1){
                root.rtb = remove(root.rtb, key);
            }else if(comp == 1){
                root.ltb = remove(root.ltb, key);
            }else{
                if(root.ltb == null && root.rtb == null){
                    root = null;
                }else if(root.rtb != null){
                    root.val = successor(root);
                    root.rtb = remove(root.rtb, cast(root.val));
                }else{
                    root.val = predecessor(root);
                    root.ltb = remove(root.ltb, cast(root.val));
                }
            }
            return root;
        }

        private T successor(Knoten root){
            root = root.rtb;
            while(root.ltb != null){
                root = root.ltb;
            }
            return cast(root.val);
        }

        private T predecessor(Knoten root){
            root = root.ltb;
            while(root.rtb != null){
                root = root.rtb;
            }
            return cast(root.val);
        }

        private T cast(Object o){
            return (T) o;
        }
    }

