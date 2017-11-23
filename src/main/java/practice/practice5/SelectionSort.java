package practice.practice5;

/**
 * Created by Baka on 24.01.2017.
 */
public class SelectionSort {
    public static void main(String[] args){
//        int[] a = {99, 33, 22, 11, 1};
        int[] a = {4, 5, 99, 3,4};
        sort(a);
        for (int i : a) System.out.println(i);
    }

    private static void sort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            int minInd = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[minInd] > a[j]){
                    minInd = j;
                }
            }

            InsertionSort.exch(a, minInd, i);
        }
    }
}
