package prep;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Baka on 16.10.2016.
 */
public class Test {
    public static void main(String[] args) {
    }

    /**
     * this method tests the LinkedList
     */
    public static void testLinkedList(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        System.out.println("Size: " + myLinkedList.getSize());
        System.out.println("GetAt: " + myLinkedList.get(1));
        myLinkedList.addAt(6, 2);
        System.out.println("Size: " + myLinkedList.getSize());
        System.out.println("GetAt2: " + myLinkedList.get(2));

        Iterator listIterator = myLinkedList.iterator();

        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

    }
}
