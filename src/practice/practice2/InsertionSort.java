package practice.practice2;

/**
 * Created by Baka on 21.01.2017.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {8, 3, 4, 12, 9, 33, 1};

        sort(a);

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort (int [] a){
        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key){
                a[j + 1] = a[j];
                j--;
            }

            a[j+1] = key;
        }
    }

    public static void sort2(int[] a){

        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i-1;

            while (j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }

    }
}
