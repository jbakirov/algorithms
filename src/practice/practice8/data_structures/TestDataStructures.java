package practice.practice8.data_structures;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Baka on 31.01.2017.
 */
public class TestDataStructures {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);

        Iterator i = linkedList.iterator();
        while (i.hasNext()) System.out.println(i.next());

        linkedList.delete(3);
        while (i.hasNext()) System.out.println(i.next());

        System.out.println("----------");

        java.util.LinkedList<Integer> linkedList1 = new java.util.LinkedList<>();
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList1.add(5);

        linkedList1.remove(3);

        ListIterator l = linkedList1.listIterator();
        while (l.hasNext()) System.out.println(l.next());

//        while (l.hasNext()) System.out.println(l.next());
    }
}
