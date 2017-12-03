package binary_tree_problems;


import java.util.Stack;

/**
 * Created by jaloliddinbakirov on 12/2/17.
 */
public class BinaryTreeTraversals {
    public static void main(String[] args) {

    }

    void inOrderTraversalRecursive(TreeNode root) {
        if (root == null) return;

        inOrderTraversalRecursive(root.left);
        System.out.println(root.val);
        inOrderTraversalRecursive(root.right);
    }

    void preOrderRecursive(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    void postOrderRecursvie(TreeNode root) {
        if (root == null) return;

        postOrderRecursvie(root.left);
        postOrderRecursvie(root.right);
        System.out.println(root.val);
    }

    /**
     *
     * @param root
     *                      a
     *                     / \
     *                    b   c
     *                   /     \
     *                  d       e
     */


    void inOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()){

            if (current != null){
                stack.push(current);
                current = current.left;
            } else {
                TreeNode n = stack.pop();
                System.out.println(n);
                current = n.right;
            }

        }
    }

    void preOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode current = stack.pop();
            if (current != null){
                System.out.println(current.val);
                stack.push(current.right);
                stack.push(current.left);
            }
        }
    }


    /**
     *
     * @param root
     *                      a
     *                     / \
     *                    b   c
     *                   /     \
     *                  d       e
     */

    void postOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();

            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null)
                    stack.push(cur.left);
                else if (cur.right != null)
                    stack.push(cur.right);
                else
                    System.out.println(stack.pop());
            } else if (cur.left == prev) {
                if (cur.right != null)
                    stack.push(cur.right);
                else
                    System.out.println(stack.pop());
            } else if (cur.right == prev) {
                System.out.println(stack.pop());
            }

            prev = cur;
        }

    }

    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
