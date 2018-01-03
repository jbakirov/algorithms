package coursera_algorithms.week4;

import java.util.Comparator;

/**
 * Created by Baka on 27.02.2016.
 * http://cs.stackexchange.com/questions/11458/quicksort-partitioning-hoare-vs-lomuto
 */
public class Quicksort {

    /*
    with Hoare partition method
     */

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        sort(numbers);

        for (int i : numbers) {
            System.out.println(i);
        }

        // 2 4 4 2 5 6 68 47 34 64 958 57 44

    }

    private static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // 21 11 18 14 37 |67 89| 97 738 483 94
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;

        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;

            if (i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }



    public int partitioning4 (Comparable[] a, int lo, int hi) {

        int i = lo, j = hi + 1;

        while(true) {
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;

            if (i >= j) break;
            exch(a, i, j);
        }

        exch(a, j, lo);

        return j;
    }

    private static int partitionG (Comparable[] a, int  lo, int hi){
        int i = lo, j = hi + 1;

        while (true){
            while (less(a[++i], a[lo])){
                if (i == hi) break;
            }
            while (less(a[lo], a[--j])){
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }


    private static int partitionG2 (Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;

        while (true){
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
