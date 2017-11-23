package coursera_algorithms.sorting;

/**
 * Created by Baka on 03.02.2016.
 */
public class ShellSorting {

    public static void main(String[] args) {
        Integer[] a = {6, 3, 4, 2, 10, 3, 23, 45};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }

            h = h / 3;
        }
    }

    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public static void sort2(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
        }

        h = h / 3;
    }


    static void sort3(Comparable[] a) {
        int N = a.length;

        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
        }

        h = h / 3;
    }


    static void sort4(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }


    static void sort5 (Comparable[] a){
        int N = a.length;

        int h = 1;
        while (h < N/3){
            h = 3 * h + 1;
        }

        while (h >= 1){
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && less(a[j], a[j-j]); j -= h){
                    exch(a, j, j-h);
                }
            }
            h/=3;
        }
    }

}
