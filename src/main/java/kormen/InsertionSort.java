package kormen;

/**
 * Created by Baka on 01.03.2016.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[]{53, 12, 3, 4, 1, 33};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);

        for (int i : array){
            System.out.println(i);
        }

    }

    private void sort (int[] a){

        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && key < a[j]){
                a[j+1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }

    }

    private int less (int a, int b){
        return a - b;
    }


    private void swap (int[] a, int b, int c){
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }


    private void sort1(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

}
