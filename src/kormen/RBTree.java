package kormen;

/**
 * Created by Baka on 28.03.2016.
 */
public class RBTree {
    Node nil = new Node();
    Node root = nil;

    void rbDelete (Node root, Node z){
        Node y = z;
        Node x;
        boolean yOriginalColor = y.red;
        if (z.left == nil){
            x = z.right;
            rbTransplant(root, z, z.right);
        } else if (z.right == nil){
            x = z.left;
            rbTransplant(root, z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.red;
            x = y.right;
            if (y.p == z)
                x.p = y;
            else {
                rbTransplant(root, y, y.right);
                y.right = z.right;
                y.right.p = y;
            }

            rbTransplant(root, z, y);
            y.left = z.left;
            y.left.p = y;
            y.red = z.red;
        }

        if (!yOriginalColor) // esli cherniy
            rbDeleteFixup(root, x);
    }

    void rbDeleteFixup(Node root, Node x){
        Node w;
        while (x != root && x.red==false){
            if (x == x.p.left){
               w = x.p.right;
                if (w.red == true){
                    w.red = false;
                    x.p.red = true;
                    rotateLeft(x.p);
                    w = x.p.right;
                }
                if (w.left.red == false && w.right.red == false){
                    w.red = true;
                    x = x.p;
                }else {
                    if (w.right.red == false){
                        w.left.red = false;
                        w.red = true;
                        rotateRight(w);
                        w = x.p.right;
                    }

                    w.red = x.p.red;
                    x.p.red = false;
                    w.right.red = false;
                    rotateLeft(x.p);
                    x = root;
                }
            } else {

                w = x.p.left;

                if (w.red == true){
                    w.red = false;
                    x.p.red = true;
                    rotateRight(x.p);
                    w = x.p.left;
                }

                if (w.right.red == false && w.left.red == false){
                    w.red = true;
                    x = x.p;
                } else {
                    if (w.left.red == false){
                        w.right.red = false;
                        w.red = true;
                        rotateLeft(w);
                        w = x.p.left;
                    }

                    w.red = x.p.red;
                    x.p.red = false;
                    w.left.red = false;
                    rotateRight(x.p);
                    x = root;
                }
            }
        }
        x.red = false;
    }

    Node minimum (Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    void rbTransplant(Node root, Node u, Node v){
        if (u.p == nil){
            root = v;
        } else if (u == u.p.left){
            u.p.left = v;
        } else {
            u.p.right = v;
        }
        v.p = u.p;
    }

    void rotateLeft(Node x) {
        if (x.right == null) return;

        Node y = x.right;
        x.right = y.left;

        if (y.left != nil) y.left.p = x;
        y.p = x.p;

        if (x.p == nil) {
            root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else x.p.right = y;
        y.left = x;
        x.p = y;
    }

    void rotateRight(Node x) {
        if (x.left == null) return;

        Node y = x.left;
        x.left = y.right;

        if (y.right != nil) y.right.p = x;
        y.p = x.p;

        if (x.p == nil) {
            root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else x.p.right = y;

        y.right = x;
        x.p = y;
    }

    void insert(Node root, Node z) {
        Node y = nil;
        Node x = root;
        while (x != nil) {
            y = x;
            if (z.key < x.key) x = x.left;
            else x = x.right;
        }
        z.p = y;
        if (y == nil) root = z;
        else if (z.key < y.key) y.left = z;
        else y.right = z;

        z.left = nil;
        z.right = nil;
        z.red = true;

        insertFixUp(root, z);
    }

    void insertFixUp(Node root, Node z) {

        while (z.p.red) {
            if (z.p == z.p.p.left) {
                Node y = z.p.p.right;
                if (y.red) {
                    z.p.red = false;
                    y.red = false;
                    z.p.p.red = true;
                    z = z.p.p;
                } else if (z == z.p.right) {
                    z = z.p;
                    rotateLeft(z);
                } else {
                    z.p.red = false;
                    z.p.p.red = true;
                    rotateRight(z.p.p);
                }
            } else {
                Node y = z.p.p.left;
                if (y.red) {
                    z.p.red = false;
                    y.red = false;
                    z.p.p.red = true;
                    z = z.p.p;
                } else if (z == z.p.left) {
                    z = z.p;
                    rotateRight(z);
                } else {
                    z.p.red = false;
                    z.p.p.red = true;
                    rotateLeft(z.p.p);
                }
            }
        }
        root.red = false;
    }


    class Node {
        Node left;
        Node right;
        Node p;
        boolean red;
        int key;

        Node() {
            left = nil;
            right = nil;
            p = nil;
            red = false;
        }
    }

}
