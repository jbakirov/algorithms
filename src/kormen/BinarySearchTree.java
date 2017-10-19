package kormen;

/**
 * Created by Baka on 27.03.2016.
 */
public class BinarySearchTree {

    void insert (Node root, Node z){
        Node y = null;
        Node x = root;

        while (x != null){
            y = x;

            if (x.key > z.key) x = x.left;
            else x = x.right;
        }

        z.parent = y;

        if (y == null) root = z;
        else if (z.key < y.key) y.left = z;
        else y.right = z;

    }

    // u - a node, which has to be changed
    // v - a node, to which has to be changed
    void transplant(Node root, Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }


    // z - a node, which needs to be deleted
    void remove(Node root, Node z) {
        if (z.left == null) {
            transplant(root, z, z.right);
        } else if (z.right == null) {
            transplant(root, z, z.left);
        } else {
            Node y = minimum(z.right);

            if (y.parent != z) {
                transplant(root, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            transplant(root, z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    Node maximum(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    class Node {
        Node left;
        Node right;
        Node parent;

        int key;
    }
}
