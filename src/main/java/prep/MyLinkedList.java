package prep;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Baka on 16.10.2016.
 */
public class MyLinkedList {
    private static int size;
    private Node head;
    private Node tale;

    public Iterator<Object> iterator(){
        final MyLinkedList linkedList = this;
        return new Iterator<Object>() {

            private Node followingNode = linkedList.head;;

            @Override
            public boolean hasNext() {
                return followingNode != null;
            }

            @Override
            public Object next() {
                if (followingNode == null){
                    throw new NoSuchElementException();
                }
                Integer data = (Integer) followingNode.data;
                followingNode = followingNode.next;
                return data;
            }
        };
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        MyLinkedList.size = size;
    }

    public void add(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tale = head;
        } else {
            tale.next = newNode;
            tale = newNode;
        }
        setSize(getSize() + 1);
    }

    public void addAt(Object data, int index) {
        Node newNode = new Node(data);
        Node currentNode = head;

        if (currentNode != null) {
            if (index == 0) {
                newNode.next = currentNode;
                size++;
                return;
            } else {
                for (int i = 1; i < index && currentNode.getNext() != null; i++) {
                    currentNode = currentNode.getNext();
                }
            }
        }

        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        setSize(getSize() + 1);
    }

    public Object get(int index) {
        if (index < 0) return null;

        Node current = head;
        if (head != null) {
            if (index == 0) return head;
//            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;
                current = current.getNext();
            }
            return current.getData();
        }
        return current;
    }

    public boolean remove(int index) {

        if (index < 1 || index > getSize()) return false;

        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) return false;

                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            setSize(getSize() - 1);
            return true;
        }
        return false;
    }


    private class Node {
        Node next;
        Object data;

        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        public Node(Object dataVal, Node nextVal) {
            next = nextVal;
            data = dataVal;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object dataVal) {
            data = dataVal;
        }

        public Node getNext() {
            return next;
        }


        public void setNext(Node nextVal) {
            next = nextVal;
        }

    }
}
