package practice.practice5;

/**
 * Created by Baka on 24.01.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {99, 33, 22, 11, 1};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j-1] > a[j]){
                    InsertionSort.exch(a, j-1, j);
                }
            }
        }
    }
}
