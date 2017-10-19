package practice.practice7;

import practice.practice5.InsertionSort;

/**
 * Created by Baka on 27.01.2017.
 */
public class QuickSortLomuto {

    public static void main(String[] args){
        int[] a = {5, 2, 4, 11, 8, 1, 14};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a)
    {
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int start, int end){
        if (start >= end) return;

        int p = partition(a, start, end);
        sort(a, start, p-1);
        sort(a, p+1, end);
    }

    private static int partition(int[] a, int start, int end){
        int p = start;

        for (int i = start; i < end; i++){
            if (a[i] <= a[end]){
                InsertionSort.exch(a, p, i);
                p++;
            }
        }
        InsertionSort.exch(a, end, p);
        return p;
    }
}
