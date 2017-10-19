package practice.practice8;

/**
 * Created by Baka on 31.01.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 12, 8, 3, 2};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a){
        for (int i = 0; i < a.length-1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j] < a[j-1]) exc(a, j, j-1);
            }
        }
    }

    private static void exc (int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
