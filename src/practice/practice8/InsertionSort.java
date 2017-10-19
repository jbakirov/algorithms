package practice.practice8;

/**
 * Created by Baka on 30.01.2017.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 12, 8, 3, 2};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int k = a[i];
            int j = i - 1;

            while (j >= 0 && k < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = k;
        }
    }

}
