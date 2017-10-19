package practice.practice9;

/**
 * Created by Baka on 08.02.2017.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 2, 1, 6, 3};
        new QuickSort().sort(a);

        for (int i : a) System.out.println(i);
    }

    public void sort (int[] a){
        sort(a, 0, a.length-1);
    }

    public void sort (int[] a, int s, int e){
        if (s >= e) return;

        int p = partition(a, s, e);
        sort(a, s, p);
        sort(a, p + 1, e);
    }


    public int partition (int[] a, int s , int e){
        int i = s - 1, j = e + 1;

        while (true) {
            while (a[++i] < a[s]) ;
            while (a[--j] > a[s]);

            if (i >= j) return j;
            exchange(a, i, j);
        }
    }

    private void exchange (int[] a, int i , int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
