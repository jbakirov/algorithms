package google_problems;

import practice.practice7.data_structures.LinkedList;

import java.util.Stack;

/**
 * Created by jaloliddinbakirov on 11/24/17.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(LinkedNode head){
        if (head == null || head.next.next == null)
            return true;

        Stack<String> stack = new Stack();
        LinkedNode slow = head;
        LinkedNode fast = head;

        while (fast != null && fast.next != null) {

            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null){
            slow = slow.next;
        }

        for (int i = 0; i < stack.size(); i++){
            if (!slow.val.equals(stack.pop())){
                return false;
            }

            slow = slow.next;
        }
        return true;
    }

    class LinkedNode{
        String val;
        LinkedNode next;
        LinkedNode(String val){
            this.val = val;
        }
    }
}
