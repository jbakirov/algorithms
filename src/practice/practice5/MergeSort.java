package practice.practice5;

/**
 * Created by Baka on 24.01.2017.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {99, 33, 22, 11, 1};
        sort(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(int[] a, int[] aux, int start, int end){
        if (start >= end) return;
        int mid = (start + end)/2;
        sort(a, aux, start, mid);
        sort(a, aux, mid+1, end);
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
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

}
