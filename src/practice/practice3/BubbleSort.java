package practice.practice3;

/**
 * Created by Baka on 22.01.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {6, 3, 87, 23, 11, 4, 40};
        sort(a);
        for(int i : a){
            System.out.println(i);
        }
    }

    public static void sort (int[] a){
        for (int i = 0; i < a.length-1; i++){
            for (int j = 1; j < a.length - i; j++){
                if (a[j-1] > a[j]){
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
