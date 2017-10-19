package practice;

/**
 * Created by Baka on 25.01.2017.
 */
public class Countingsort {
    public static void main(String[] args) {
        int[] a = {19, 5, 9, 3, 8, 11, 1, 15, 2};
        int[] b = new int[a.length];
        sort(a, b);
        for (int i : b) System.out.println(i);
    }

    private static void sort(int[] a, int[] b) {
        sort(a, b, 19);
    }

    private static void sort(int[] a, int[] b, int k) {
        int[] c = new int[k + 1];

        for (int i = 0; i < a.length; i++) {
            c[a[i]] = c[a[i]] + 1;
        }

        for (int i = 1; i <= k; i++) {
            c[i] = c[i - 1] + c[i];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]] = c[a[i]] - 1;
        }
    }
}
