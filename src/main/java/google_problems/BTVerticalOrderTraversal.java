package google_problems;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by jaloliddinbakirov on 11/24/17.
 */
public class BTVerticalOrderTraversal {

    public static void main(String[] args) {

    }

    public static List<ArrayList<Integer>> traversal(TreeNode root) {
        List<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while (!q.isEmpty()){
            TreeNode current = q.poll();
            int col = cols.poll();

            if (!map.containsKey(col))
                map.put(col, new ArrayList<Integer>());

            map.get(col).add(current.val);

            if (current.left != null){
                q.add(current.left);
                cols.add(col-1);
                min = Math.min(min, col-1);
            }

            if (current.right != null){
                q.add(current.right);
                cols.add(col+1);
                min = Math.max(max, col+1);
            }
        }

        for (int i = min; i <= max; i++){
            result.add(map.get(i));
        }

        return result;
    }

    class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int x) {val = x;}

        public TreeNode add(TreeNode root, int val){
            if (root == null) return new TreeNode(val);

            if (root.val > val){
                root.left = add(root.left, val);
            } else if (root.val < val){
                root.right = add(root.right, val);
            } else {
                root.val = val;
            }

            return root;
        }
    }
}
