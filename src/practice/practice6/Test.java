package practice.practice6;

import practice.practice7.data_structures.*;

/**
 * Created by Baka on 01.02.2017.
 */
public class Test {
    public static void main (String[] args){
        Heap<Integer> heap = new Heap();
        heap.insert(2);
        heap.insert(15);
        heap.insert(1);
        heap.insert(7);
        heap.insert(33);

        System.out.println(heap.popMax());
        Integer[] a = {5, 2, 3 , 6, 1, 2, 18, 13};
        heap.sort(a);
        for (int i : a) System.out.println(i);
    }
}
