package practice;

/**
 * Created by Baka on 20.01.2017.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 7, 3, 9};
        sort(a);

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort(int[] a){
        for (int i = 0; i < a.length-1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j-1] > a[j]) swap(a, j-1, j);
            }
        }
    }

    public static void swap (int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
