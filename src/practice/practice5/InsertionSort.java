package practice.practice5;

/**
 * Created by Baka on 24.01.2017.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {99, 33, 22, 11, 1};
        sort(a);
        for (int i : a){
            System.out.println(i);
        }
    }

    private static void sort(int[] a){
        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && key < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    public static void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
