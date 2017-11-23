package practice.practice8;

/**
 * Created by Baka on 30.01.2017.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 12, 8, 3, 2};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a){

        for (int i = 0; i < a.length - 1; i++){
            int min = i;

            for (int j = i + 1; j < a.length; j++){
                if (a[min] > a[j]){
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    private static void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
