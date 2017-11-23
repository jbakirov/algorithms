package khanacademy;

/**
 * Created by Baka on 13.02.2016.
 */
public class InsertionSorting {

    public static void main(String[] args) {
//        int[] array = new int[]{22, 11, 99, 88, 9, 7, 42};

//        insert(array, 2, 4);

        int[] array = new int[] {14, 2, 4, 13, 90};

        for (int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;
            while (j>= 0 && key < array[j]){
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j+1] = key;
        }


        for (int i: array){
            System.out.println(i);
        }


    }



    static void insert(int[] array, int rightIndex, int value) {
        int i;
        for (i = rightIndex; i >= 0 && array[i] > value; i--) {
            array[i + 1] = array[i];
        }
        array[i + 1] = value;
    }
}
