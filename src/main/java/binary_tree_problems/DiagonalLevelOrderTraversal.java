package binary_tree_problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaloliddinbakirov on 12/3/17.
 */
public class DiagonalLevelOrderTraversal {

    public static void main(String[] args) {

    }

    void diagonalLevelTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (root.right != null){
            queue.add(root.right);
            root = root.right;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                if (queue.peek().left != null){
                    queue.add(queue.peek().left);
                    Node last = queue.peek();
                    while (last.right !=null){
                        queue.add(last.right);
                        last = queue.peek();
                    }
                }
                size--;
                System.out.print(queue.poll().val);
            }
            System.out.println();
        }
    }


    void diagonalLevelTraversalInOneLine(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (root != null){
            queue.add(root.right);
            root = root.right;
        }

        while (!queue.isEmpty()){
            Node cur = queue.peek();
            if (cur.left != null){
                queue.add(cur.left);
                cur = cur.left;
                while (cur.right != null){
                    queue.add(cur.right);
                    cur = cur.right;
                }
            }
            System.out.print(queue.poll().val + " ");
        }
    }


    class Node {
        int val;
        Node left;
        Node right;
    }
}
