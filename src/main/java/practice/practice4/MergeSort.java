package practice.practice4;

/**
 * Created by Baka on 23.01.2017.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {23, 19, 2, 18, 33, 1, 9};
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

        int mid = (start + end) / 2;
        sort(a, aux, start, mid);
        sort(a, aux, mid + 1, end);
        merge(a, aux, start, end, mid);
    }

    public static void merge(int[] a, int[] aux, int start, int end, int mid) {
        for (int i = start; i <= end; i++){
            aux[i] = a[i];
        }

        int i = start, j = mid + 1;

        for (int k = start; k <= end; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > end) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }


}

