package coursera_algorithms.week4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by Baka on 27.02.2016.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int count;

        public Node(Key key, Value val){
            this.key = key;
            this.val = val;
        }
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    public Node put(Node x, Key key, Value val){
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if(cmp>0)
            x.right = put(x.right, key, val);
        else x.val = val;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key){
        Node x = root;
        while (x!=null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete (Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node min (Node x){
        if (x.left == null) return x;
        return min(x.left);
    }

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */

    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    public Node floor(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0) return x;

        if (cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0;
        return x.count;
    }

    public int rank (Key key){
        return rank(key, root);
    }

    private int rank(Key key, Node x){
        if (x==null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Iterable<Key> iterator(){
        Queue<Key> q = new LinkedList<>();
        inOrder(root, q);
        return q;
    }

    private void inOrder (Node x, Queue<Key> q){
        if (x == null) return;
        inOrder(x.left, q);
        q.add(x.key);
        inOrder(x.right, q);
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in the symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("called ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>();

//        binarySearchTree.put(7, 8);
//        binarySearchTree.put(3, 4);
//        binarySearchTree.put(0, 1);
//        binarySearchTree.put(2, 3);
//        binarySearchTree.put(1, 2);
//        binarySearchTree.put(4, 5);
//        binarySearchTree.put(5, 6);
//        binarySearchTree.put(6, 7);

        binarySearchTree.put(26, 1);
        binarySearchTree.put(13, 1);
        binarySearchTree.put(6, 1);
        binarySearchTree.put(3, 1);
        binarySearchTree.put(15, 1);
        binarySearchTree.put(54, 1);
        binarySearchTree.put(51, 1);
        binarySearchTree.put(56, 1);

//        System.out.println(binarySearchTree.ceiling(7));

//        for (Integer i: binarySearchTree.iterator()){
//            System.out.println(i);
//        }
//
        binarySearchTree.delete(3);
//
//        System.out.println("______");
        for (Integer i: binarySearchTree.iterator()){
            System.out.println(i);
        }
    }

}
