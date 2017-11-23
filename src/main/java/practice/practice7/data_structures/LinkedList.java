package practice.practice7.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Baka on 27.01.2017.
 */
public class LinkedList<T> {

    private int size = 0;
    private Node head;

    public void add (T n){
        Node node = new Node(n);

        if (head == null) head = node;
        else {
            Node c = head;
            while (c.next != null){
                c = c.next;
            }

            c.next = node;
        }

        size++;
    }

    public boolean remove (T n){
        if (head == null) return false;

        if (head.value == n){
            head = head.next;
        } else {
            Node c = head;
            while (c.next != null && c.next.value != n){
                c = c.next;
            }

            if (c.next != null && c.next.value == n){
                c.next = c.next.next;
            } else {
                throw new NoSuchElementException();
            }
        }
        size--;
        return true;
    }

    public Iterator<T> iterator(){
        return new Iterator<T>() {

            Node c = head;

            @Override
            public boolean hasNext() {
                return c != null;
            }

            @Override
            public T next() {
                if (c == null) throw new NoSuchElementException();
                T r = (T) c.value;
                c = c.next;
                return r;
            }
        };
    }

    private class Node<T>{

        Node(T v){
            value = v;
        }

        Node next;
        T value;
    }
}
