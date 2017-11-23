package practice.practice9;

/**
 * Created by Baka on 08.02.2017.
 */
public class InsertionSort {
    public static void main(String[] args) {

    }

    public void sort(Integer[] a){

        for (int i = 1; i < a.length; i++){
            int k = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > k){
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = k;
        }
    }
}
