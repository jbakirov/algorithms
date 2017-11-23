package practice.practice8;

/**
 * Created by Baka on 01.02.2017.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    Node root;

    public void add(T val) {
        root = add(root, val);
    }

    public Node add(Node x, T val) {
        if (x == null) return new Node(val);
        int cmp = val.compareTo(root.value);

        if (cmp < 0)
            x.left = add(x.left, val);
        else if (cmp > 0)
            x.right = add(x.right, val);
        else
            x.value = val;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public int rank(T val) {
        return rank(root, val);
    }

    private int rank(Node x, T val) {
        if (x == null) return 0;
        int cmp = val.compareTo(x.value);

        if (cmp < 0) return rank(x.left, val);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, val);
        else return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) return null;
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void inOrder(Node x) {
        if (x == null) return;
        inOrder(x.left);
        System.out.println(x.value);
        inOrder(x.right);
    }


    class Node {
        T value;
        Node left;
        Node right;
        int count;

        Node(T v) {
            value = v;
        }
    }

    /* !!!!!!!!!!!!!!!!!!! */

    public int sizeOfTree(Node x) {
        if (x == null) return 0;
        return 1 + sizeOfTree(x.left) + sizeOfTree(x.right);
    }

    public void insert(T val) {
        root = insert(root, val);
    }

    private Node insert(Node x, T val) {
        if (x == null) return new Node(val);
        int cmp = val.compareTo(x.value);
        if (cmp < 0) return insert(x.left, val);
        else if (cmp > 0) return insert(x.right, val);
        else x.value = val;

        return x;
    }


    public void inOrderTraversal(Node x) {
        if (x == null) return;
        inOrderTraversal(x.left);
        System.out.println(x.value);
        inOrderTraversal(x.right);
    }


    public T minValue(Node x) {
        if (x == null) return null;
        if (x.left != null) return minValue(x.left);
        else return x.value;
    }

    public int maxDepth(Node x) {
        if (x == null) return 0;
        return Math.max(maxDepth(x.left), maxDepth(x.right)) + 1;
    }

    public boolean isBST(Node x) {
        if (x == null) return false;

        if (x.left != null && x.right != null) {
            if (less(x.left, x) && less(x, x.right)) return isBST(x.left) && isBST(x.right);
            else return false;
        } else if (x.left != null && x.right == null){
            if (less(x.left, x)) return isBST(x.left);
            else return false;
        } else if (x.left == null && x.right != null){
            if (less(x, x.right)) return isBST(x.right);
            else return false;
        } else return true;
    }

    private boolean less(Node x, Node y) {
        return x.value.compareTo(y.value) < 0;
    }

    public void printAllPaths (Node x, Node[] path, int pathLen){
        if (x == null) return;

        path[pathLen++] = x;

        if(x.left == null && x.right == null) printPath(path, pathLen);
        else {
            printAllPaths(x.left, path, pathLen);
            printAllPaths(x.right, path, pathLen);
        }

    }

    private void printPath(Node[] path, int pathLen){
        /* print path */
    }

    public boolean sameTree (Node x, Node x2){
        if (x == null && x2 == null) return true;
        else if (x != null && x2 != null){
            return x.value == x2.value &&
                    sameTree(x.left, x2.left) &&
                    sameTree(x.right, x2.right);
        } else {
            return false;
        }
    }

    public int diameter (Node x){
        if (x == null) return 0;

        int lheight = height(x.left);
        int rheight = height(x.right);

        int ldiameter = diameter(x.left);
        int rdiameter = diameter(x.right);

        return Math.max((1 + lheight + rheight), Math.max(ldiameter, rdiameter));
    }

    public int height (Node x){
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public Node lowestCommonAncestor (Node x, Node a, Node b){
        if (x == null) return null;

        if (a == x || b == x) return x;

        Node l = lowestCommonAncestor(x.left, a, b);
        Node r = lowestCommonAncestor(x.right, a, b);

        if (l != null && r != null) return x;
        else if (l == null && x == null) return null;
        else return l == null ? r : l;
    }

    public void postOrder (Node x){
        if (x == null) return;

        postOrder(x.left);
        postOrder(x.right);
        System.out.println(x.value);
    }
}
