package binary_tree_problems;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaloliddinbakirov on 12/3/17.
 *
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {

    }


    void printLevelOrderLineByLine(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {

            int size = queue.size();
            if (size == 0) break;

            while (size > 0) {
                TreeNode n = queue.poll();
                System.out.print(n.val);
                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
                size--;
            }
            System.out.println();
        }

    }



    /*************************************************************************************************************
     * complexity O(n)
     * with queue
     * @param root
     */
    void printLevelOrderQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.println(temp.val);

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }




    /**************************************************************************************************************
     * N^2 in worst case
     * @param node
     * @return
     */
    public int height(TreeNode node){
        if (node == null) return 0;

        int lheight = height(node.left);
        int rheight = height(node.right);

        if (lheight > rheight)
            return lheight + 1;
        else
            return rheight + 1;
    }

    public void printLevelOrder(TreeNode root) {
        int h = height(root);
        for (int i = 1; i <= h; i++){
            printGivenLevel(root, i);
        }
    }

    public void printGivenLevel(TreeNode root, int level) {
        if (root == null) return;
        if (level == 1) System.out.println(root.val);
        else if (level > 1){
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
