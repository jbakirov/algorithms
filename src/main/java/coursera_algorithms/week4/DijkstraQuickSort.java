package coursera_algorithms.week4;

/**
 * Created by Baka on 27.02.2016.
 * 3 - way sorting
 */
public class DijkstraQuickSort {

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{5, 3, 12, 4, 66, 1};
        sort(numbers);

        for (int i : numbers){
            System.out.println(i);
        }
    }

    private static void sort (Comparable[] a){
        sort(a, 0, a.length - 1);
    }

    private static void sort (Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
