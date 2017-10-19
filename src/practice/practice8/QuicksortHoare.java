package practice.practice8;

/**
 * Created by Baka on 30.01.2017.
 */
public class QuicksortHoare {

    public static void main(String[] args) {
        int[] a = {5, 3, 12, 8, 3, 2};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int start, int end) {
        if (start >= end) return;

        int p = pivot(a, start, end);
        sort(a, start, p);
        sort(a, p + 1, end);
    }

    private static int pivot(int[] a, int s, int e) {
        int i = s - 1, j = e + 1;

        while (true) {
            while (a[++i] < a[s]) ;
            while (a[s] < a[--j]) ;

            if (i >= j) return j;

            exch(a, i, j);
        }
    }

    private static void exch(int[] a, int i , int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
