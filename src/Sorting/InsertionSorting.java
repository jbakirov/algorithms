package Sorting;

/**
 * Created by Baka on 17.01.2016.
 */
public class InsertionSorting {

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3};
        int[] array = new int[]{22, 11, 99, 88, 9, 7, 42};


        new InsertionSorting().insertionSort6(array);

        for (int i : array) {
            System.out.println(i);
        }
    }

    // для небольшого массива
    void insertionSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
    }

    void insertionSort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    void insertionSortMe(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    void insertionSortDescending(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    void insertionSort3(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    void insertionSort4(int[] a){

        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i - 1;

            while(j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j = j -1;
            }
            a[j + 1] = key;
        }
    }


    void insertionSort5 (int [] a){
        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j -= 1;
            }
            a[j + 1] = key;
        }
    }

    void insertionSort6 (int[] a){
        for (int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j -=1;
            }

            a[j+1] = key;
        }
    }

}
