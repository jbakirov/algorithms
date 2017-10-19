package practice.practice8.data_structures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Baka on 31.01.2017.
 */
public class LinkedList<T extends Comparable<T>> {

    public int size = 0;
    private Node head;

    public void add (T v){
        Node n = new Node(v);

        if (head == null) head = n;
        else {
            Node c = head;
            while (c.next != null) c = c.next;
            c.next = n;
        }
    }

    public void delete (T v){

        if (head == null) throw new NoSuchElementException();
        if (head.value == v) {
            head = head.next;
            return;
        }

        Node c = head;
        while (c.next != null && c.next.value != v)
            c = c.next;

        if (c.next != null && c.next.value == v){
            c.next = c.next.next;
        }
        else throw new NoSuchElementException();
    }

    public Iterator iterator (){
        return new Iterator() {

            Node c = head;
            @Override
            public boolean hasNext() {
                return c != null;
            }

            @Override
            public T next() {
                T v = c.value;
                c = c.next;
                return v;
            }
        };
    }

    public class Node{
        T value;
        Node next;

        Node(T v, Node n){
            value = v;
            next = n;
        }

        Node (T v){
            value = v;
        }

    }
}
