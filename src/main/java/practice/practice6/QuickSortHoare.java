package practice.practice6;

/**
 * Created by Baka on 26.01.2017.
 */
public class QuickSortHoare {
    public static void main(String[] args) {
        int[] a = {5, 3, 7, 13, 44, 2, 1};
        sort(a);
        for(int i : a) System.out.println(i);
    }

    private static void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int start, int end){
        if (start >= end) return;
        int p = partition(a, start, end);
        sort(a, start, p);
        sort(a, p + 1, end);
    }

    private static int partition(int[] a, int start, int end){
        int i = start - 1, j = end + 1;

        while (true){
            while (a[++i] < start);
            while (a[start] < a[--end]);

            if (i >= j) return j;

        }
    }

}
