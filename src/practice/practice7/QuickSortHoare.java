package practice.practice7;

import practice.practice5.InsertionSort;

/**
 * Created by Baka on 27.01.2017.
 */
public class QuickSortHoare {
    public static void main(String[] args) {
        int[] a = {5, 2, 4, 11, 8, 1, 14};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int start, int end){
        if (start >= end) return;

        int p = partition(a, start, end);
        sort(a, start, p);
        sort(a, p+1, end);
    }

    private static int partition(int[] a, int start, int end){
        int i = start -1, j = end + 1;

        while(true){
            while (a[++i] < a[start]);
            while (a[start] < a[--j]);

            if (i >= j) return j;
            InsertionSort.exch(a, i, j);
        }
    }
}
