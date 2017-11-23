package khanacademy;

/**
 * Created by Baka on 13.02.2016.
 */
public class SelectionSorting {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 8, 6, 1, 10};


        for (int i = 0; i < array.length; i++){
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }


        for (int i : array){
            System.out.println(i);
        }

        selectionSort(array);


        for (int i : array){
            System.out.println(i);
        }

    }

    static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    static int indexOfMinimum (int[] array, int startIndex){
        int minValue = array[startIndex];
        int minIndex = startIndex;
        for (int i = startIndex + 1; i <  array.length; i++){
            if (minValue > array[i]){
                minIndex = i;
                minValue = array[i];
            }
        }
        return minIndex;
    }

    static void selectionSort (int[] array){
        int minIndex = 0;
        for (int i = 0; i < array.length; i++){
            minIndex = indexOfMinimum(array, i);
            swap(array, i, minIndex);
        }
    }

    static void selectionSort2 (int[] a){
        int minIndex = 0;
        for (int i = 0; i < a.length; i++){

        }
    }
}
