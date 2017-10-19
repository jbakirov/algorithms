package practice;

/**
 * Created by Baka on 21.01.2017.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {19, 12, 7, 8, 11, 23, 25};
        int [] a1 = {11, 12, 7, 8};
        sort(a1);
//        sort(a);

        for(int i : a1){
            System.out.println(i);
        }
    }

    public static void sort (int[] a){
        sort(a, 0, a.length-1);
    }

    public static void sort (int[] a, int start, int end){
        if (start >= end) return;
        int j = partition(a, start, end);
        sort(a, start, j-1);
        sort(a, j+1, end);
    }

    public static int partition(int[] a, int start, int end){
        int i = start, j = end + 1;

        while (true){
            while (a[++i] < a[start]) if (i == end) break;
            while (a[start] < a[--j]) if (j == start) break;

            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, start, j);
        return j;
    }

    public static void exchange (int[] a, int i, int j){
        int tm = a[i];
        a[i] = a[j];
        a[j] = tm;
    }
}
