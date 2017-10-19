package practice.practice2;

/**
 * Created by Baka on 21.01.2017.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {4, 5, 99, 3,4};

        sort(a);

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort (int[] a){

        for (int i = 0; i < a.length; i++){
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[minIndex] > a[j]){
                    minIndex = j;
                }
            }

            int tmp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = tmp;
        }
    }

}
