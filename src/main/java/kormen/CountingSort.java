package kormen;

/**
 * Created by Baka on 21.03.2016.
 */
public class CountingSort {

    /*
    known also as Histogram Sort
    stable
    O(n + k);
     */

    private static int[] c;

    public void sort(int[] a, int[] b, int k){
        c = new int[k + 1];

        for (int i = 0; i <= k; i++){
            c[i] = 0;
        }

        for (int i = 0; i < a.length; i++){
            c[a[i]] = c[a[i]] + 1;
//            System.out.println(c[a[i]]);
        }

        for (int i = 1; i <= k; i++){
            c[i] = c[i] + c[i-1];
        }

        for (int i = a.length - 1; i >= 0; i--){
            b[c[a[i]] - 1] = a[i];
            c[a[i]] = c[a[i]]- 1;
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 5, 3, 0, 2, 3, 0, 3, 7};
        int b[] = new int[a.length];

        new CountingSort().sort(a, b, 7);

        for (int i : b){
            System.out.println(i);
        }
    }

}
