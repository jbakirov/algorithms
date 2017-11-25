package google_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaloliddinbakirov on 11/24/17.
 */
public class BinaryTreePaths {

    public static void main(String[] args) {

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (result == null) return result;

        helper(new String(), root, result);

        return result;
    }

    public static void helper(String current, TreeNode root, List<String> result){
        if (root.left == null && root.right == null) result.add(current + root.val);
        else if (root.left != null) helper(current + root.val + "->", root.left, result);
        else if (root.right != null) helper(current + root.val + "->", root.right, result);
    }

    public static void secondVersion(TreeNode[] path, int length, TreeNode node) {
        if (node == null) return;

        path[length] = node;
        length++;

        if (node.left == null && node.right == null){
            printSecondVersion(path, length);
        } else {
            secondVersion(path, length, node.left);
            secondVersion(path, length, node.right);
        }
        

    }

    public static void printSecondVersion(TreeNode[] path, int length){
        for (int i = 0; i < length; i++){
            System.out.println(path[i]);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int  x) {this.val = x;}
    }
}
