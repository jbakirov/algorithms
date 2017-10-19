package kormen;

/**
 * Created by Baka on 03.03.2016.
 */
public class TwoThreeSeven {

    static int[] aux;

    public static void main(String[] args) {
        int[] input = new int[] {4, 23, 56, 1, 14, 73, 5};
        int x = 77;
        sort(input);

        for (int i = 0; i < input.length; i++){
            int r = binarySearch(input, x-input[i]);
            if ( r > 0){
                System.out.println(r);
                break;
            }
        }

//        System.out.println(binarySearch(input,  14));
    }

    private static int binarySearch(int[] a, int x){
        int mid = 0;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            mid = (hi + lo) / 2;
            if (a[mid] == x) return a[mid];
            else if (a[mid] > x) hi = mid - 1;
            else if (a[mid] < x) lo = mid + 1;
        }
        return -1;
    }


    private static void merge(int[] a, int[] aux, int lo, int mid, int hi){

        for (int i = lo; i <= hi; i++){
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k  <= hi; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }

    }

    private static boolean less (int a, int b){
        return a - b < 0;
    }

    private static void sort(int[] a){
        aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }

    private static void sort(int[] a, int[] aux, int lo, int hi){
        if (hi <= lo) return;
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }


}
