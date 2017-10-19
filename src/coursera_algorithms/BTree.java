package coursera_algorithms;

import java.util.Map;

/**
 * Created by Baka on 21.04.2016.
 */
public class BTree <Key extends Comparable<Key>, Value> {

    //max childen per B-tree node = M -1
    // must be even and greater than 2

    private static final int M = 3;

    private Node root;
    private int height;
    private int N;

    private static final class Node {
        private int m;                          // number of children
        private Entry[] children = new Entry[M]; // the array of children

        private Node(int k){
            m = k;
        }
    }

    private static class Entry {
        private Comparable key;
        private Object val;
        private Node next;
        public Entry(Comparable key, Object val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public BTree(){
        root = new Node(0);
    }

    public boolean isEmpty (){
        return size() == 0;
    }

    public int size (){
        return N;
    }

    public int height (){
        return height;
    }

    public Value get (Key key){
        if (key == null) throw new NullPointerException("key must not be null");
        return search(root, key, height);
    }

    private Value search(Node x, Key key, int ht){
        Entry[] children = x.children;

        if (ht == 0){
            for (int j = 0; j < x.m; j++){
                if (eq(key, children[j].key)) return (Value) children[j].val;
            }
        } else {
            for (int j = 0; j < x.m; j++){
                if (j+1 == x.m || less (key, children[j+1].key))
                    return search(children[j].next, key, ht-1);
            }
        }
        return null;
    }

    public void put (Key key, Value val){
        if (key == null) throw new NullPointerException("key must not be null");
        Node u = insert(root, key, val, height);
        N++;
        if (u == null) return;

        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }

    private Node insert (Node h, Key key, Value val, int ht){
        int j;
        Entry t = new Entry(key, val, null);

        if (ht == 0){
            for (j = 0; j < h.m; j++){
                if (less(key, h.children[j].key)) break;
        }
        } else {
            for ( j = 0; j < h.m; j++){
                if ( (j + 1 == h.m) || less(key, h.children[j+1].key)){
                    Node u = insert(h.children[j++].next, key, val, ht-1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--)
            h.children[i] = h.children[i-1];
        h.children[j] = t;
        h.m++;
        if (h.m < M)    return null;
        else            return split(h);
    }

    private Node split(Node h){
        Node t = new Node(M/2);
        h.m = M/2;
        for (int j = 0; j < M/2; j++)
            t.children[j] = h.children[M/2 + j];
        return t;
    }


    private boolean less (Comparable k1, Comparable k2){
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2){
        return k1.compareTo(k2) == 0;
    }


    public static void main(String[] args) {
        BTree<String, String> st = new BTree<>();
        st.put("one", "1");
        st.put("two", "2");
        st.put("three", "3");
        st.put("four", "4");
        st.put("five", "5");
        st.put("six", "6");
        st.put("seven", "7");
        st.put("eigh", "8");
        st.put("nine", "9");
        st.put("ten", "10");
        st.put("twelve", "11");
        st.put("eleven", "12");

        st.put("thirteen", "13");
        st.put("fourteen", "14");
        st.put("fifteen", "15");
        st.put("sixteen", "16");
        st.put("seventeen", "17");
        st.put("eighteen", "18");
        st.put("nineteen", "19");
        st.put("twenty", "20");
        st.put("twenty one", "21");
        st.put("twenty two", "22");
        st.put("twenty three", "23");
        st.put("twenty four", "24");

        st.put("twenty five", "25");
        st.put("twenty six", "26");
        st.put("twenty seven", "27");
        st.put("twenty eight", "28");
        st.put("twenty nine", "29");
        st.put("thirty", "30");
        st.put("thirty one", "31");
        st.put("thirty two", "32");
        st.put("thirty three", "33");
        st.put("thirty four", "34");
        st.put("thirty five", "35");
        st.put("thirty six", "36");


        System.out.println(st.get("first"));
    }

}
