package practice.practice2;

/**
 * Created by Baka on 21.01.2017.
 * Hoares Partitioning
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 99, 3, 4};
        int[] a1 = {1, 2, 3, 4 ,5 , 6};
        sort(a);
        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort (int [] a){
        sort(a, 0, a.length-1);
    }

    public static void sort (int[] a, int start, int end){
        if (start >= end) return;

        int p = partition (a, start, end);
        sort(a, start, p);
        sort(a, p + 1, end);
    }

    public static int partition (int[] a, int start, int end){
        int i = start-1, j = end + 1;
//        int x = a[start];

        while (true){
            while (a[++i] < a[start]);
            while (a[start] < a[--j]);

            if (i >= j){
                return j;
            }
            exchange(a, i, j);
        }
    }


    public static void exchange (int[] a, int i, int j){
        int tm = a[i];
        a[i] = a[j];
        a[j] = tm;
    }

}
