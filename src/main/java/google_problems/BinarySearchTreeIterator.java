package google_problems;

import java.util.Stack;

/**
 * Created by jaloliddinbakirov on 11/24/17.
 */
public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        Node root = new Node(8);
        root.add(root, 4);
        root.add(root, 9);
        root.add(root,1);
        root.add(root,2);
        root.add(root,3);
        root.add(root,5);
        root.add(root,6);
        root.add(root,7);
        root.add(root,0);

        BinarySearchTreeIterator bsti = new BinarySearchTreeIterator(root);
        while (bsti.hasNext()){
            System.out.println(bsti.next());
        }
    }

    Stack<Node> stack;
    Node root;

    BinarySearchTreeIterator (Node root){
        stack = new Stack<>();
        this.root = root;

        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next(){

        Node nextSmallest = stack.pop();
        Node addToStack = nextSmallest.right;

        while (addToStack != null){
            stack.add(addToStack);
            addToStack = addToStack.left;
        }

        return nextSmallest.val;
    }

    private static class Node{
        int val;

        Node right;
        Node left;

        Node(int val){
            this.val = val;
        }

        public Node add(Node node, int val){
            if (node == null) return new Node(val);

            if (val < node.val){
                node.left = add(node.left, val);
            } else if (val > node.val){
                node.right = add(node.right, val);
            } else {
                node.val = val;
            }
            return node;
        }
    }


}
