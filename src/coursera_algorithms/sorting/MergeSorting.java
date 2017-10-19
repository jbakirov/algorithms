package coursera_algorithms.sorting;

/**
 * Created by Baka on 26.02.2016.
 */
public class MergeSorting {

    static Comparable[] aux;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }



    public static void sort1(Comparable[] a) {
        aux = new Comparable[a.length];
        sort1(a, aux, 0, a.length - 1);
    }


    public static void sort1(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (hi + lo) / 2;
        sort1(a, aux, lo, mid);
        sort1(a, aux, mid + 1, hi);
        mergeG(a, aux, lo, mid, hi);
    }

    public static void merge1(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }





    public static void sortG (Comparable[] a){
        aux = new Comparable[a.length];
        sortG(a, aux, 0, a.length - 1);
    }

    public static void sortG (Comparable []a, Comparable []aux, int l, int hi){
        if (hi <= l) return;
        int mid = (hi + l) / 2;

        sortG(a, aux, l, mid);
        sortG(a, aux, mid+1, hi);
        mergeG(a, aux, l, mid, hi);
    }

    private static void mergeG (Comparable[] a, Comparable[] aux, int l, int mid, int hi){
        for (int i = l; i <= hi; i++){
            aux[i] = a[i];
        }

        int i = l, j = mid + 1;

        for (int k = l; k <= hi; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(a[i], a[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
    public static void main(String[] args) {
        Integer[] a = new Integer[]{4, 13, 2, 1, 0, 56};

        MergeSorting mergeSorting = new MergeSorting();
//        mergeSorting.sort1(a);

        mergeSorting.sortG(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
