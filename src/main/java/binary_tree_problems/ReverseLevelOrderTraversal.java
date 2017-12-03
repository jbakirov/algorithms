package binary_tree_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jaloliddinbakirov on 12/3/17.
 */
public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {

    }

    void reverseLevelOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            stack.push(cur);

            if (cur.right != null)
                queue.add(cur.right);
            if (cur.left != null)
                queue.add(cur.left);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }

    class Node {
        int val;
        Node left;
        Node right;
    }
}
