package practice.practice3;

/**
 * Created by Baka on 22.01.2017.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {6, 3, 87, 23, 11, 4, 40};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void sort(int[] a, int[] aux, int start, int end) {
        if (start >= end) return;
        int m = (start + end) / 2;
        sort(a, aux, start, m);
        sort(a, aux, m + 1, end);
        merge(a, aux, start, end, m);
    }

    public static void merge(int[] a, int[] aux, int start, int end, int m) {
        for (int i = start; i <= end; i++) {
            aux[i] = a[i];
        }

        int i = start, j = m + 1;

        for (int k = start; k <= end; k++) {
            if (i > m) a[k] = aux[j++];
            else if (j > end) a[k] = aux[i++];
            else if (aux[i] > aux[j]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }
}
