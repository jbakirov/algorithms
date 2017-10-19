package practice.practice2;

/**
 * Created by Baka on 21.01.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {4, 2, 9, 43, 23, 11};
        sort(a);

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j-1] > a[j]){
                    int t = a[j-1];
                    a[j-1] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    public static void sort2 (int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j-1] > a[j]){
                    int t = a[j-1];
                    a[j-1] = a[j];
                    a[j] = t;
                }
            }
        }
    }
}
