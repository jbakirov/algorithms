package practice;

/**
 * Created by Baka on 20.01.2017.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {3, 2, 6, 53, 9};

        sort(a);

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
