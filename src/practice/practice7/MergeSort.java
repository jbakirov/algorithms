package practice.practice7;

/**
 * Created by Baka on 27.01.2017.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {5, 2, 4, 11, 8, 1, 14};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a){
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }

    private static void sort(int[] a, int[] aux, int start, int end){
        if (start >= end) return;

        int mid = (start + end) / 2;
        sort(a, aux, start, mid);
        sort (a, aux, mid + 1, end);
        merge(a, aux, start, end, mid);
    }

    private static void merge(int[] a, int[] aux, int start, int end, int mid){
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
