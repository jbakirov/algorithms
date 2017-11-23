package practice.practice5;

/**
 * Created by Baka on 24.01.2017.
 */
public class QuicksortHoare {

    public static void main(String[] args) {
//        int[] a = {17, 4, 19, 88, 2, 63, 22};
//        int[] a = {23, 19, 2, 18, 33, 1, 9};
        int[] a = {99, 33, 22, 11, 1};
        sort (a);

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (start >= end) return;

        int p = partition(a, start, end);
        sort(a, start, p);
        sort(a, p + 1, end);
    }

    public static int partition(int[] a, int start, int end){
        int i = start-1, j = end + 1;

        while (true){
            while (a[++i] < a[start]);
            while (a[start] < a[--j]);

            if (i >= j) return j;
            exch(a, i, j);
        }
    }

    public static void exch(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
