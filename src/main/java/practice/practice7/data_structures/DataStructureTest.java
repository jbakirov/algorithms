package practice.practice7.data_structures;

import java.util.Iterator;

/**
 * Created by Baka on 27.01.2017.
 */
public class DataStructureTest {

    public static void main(String[] args) {
        Integer[] a = {54, 12, 33, 2, 1, 15, 29};
        Heap<Integer> heap = new Heap();
        heap.sort(a);

        for (int i : a) System.out.println(i);
    }
}
