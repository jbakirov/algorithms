package khanacademy;

/**
 * Created by Baka on 14.02.2016.
 *
 */
public class MergeSorting {

    public static void main(String[] args) {
        int[] array = new int[]{3, 6};
        mergeSort(array, 0, 1);

        for (int i : array){
            System.out.println(i);
        }
    }

    static void merge(int[] array, int firstIndex, int midIndex, int lastIndex) {

        int[] lowHalf = new int[midIndex - firstIndex + 1];
        int[] highHalf = new int[lastIndex - midIndex];

        int k = firstIndex;
        int i;
        int j;

        for (i = 0; k <= midIndex; k++, i++) {
            lowHalf[i] = array[k];
        }

        for (j = 0; k <= lastIndex; k++, j++) {
            highHalf[j] = array[k];
        }

        k = firstIndex;
        i = 0;
        j = 0;

        while (i < lowHalf.length && j < highHalf.length) {
            if (lowHalf[i] < highHalf[j]){
                array[k] = lowHalf[i];
                i++;
            }else {
                array[k] = highHalf[j];
                j++;
            }
            k++;
        }

        while (i < lowHalf.length){
            array[k] = lowHalf[i];
            i++;
            k++;
        }

        while (j < highHalf.length){
            array[k] = highHalf[j];
            j++;
            k++;
        }

    }

    static void mergeSort(int[] array, int firstIndex, int lastIndex) {
        if (lastIndex - firstIndex >= 1) {
            int midIndex = (lastIndex + firstIndex) / 2;
            mergeSort(array, firstIndex, midIndex);
            mergeSort(array, midIndex + 1, lastIndex);
            merge(array, firstIndex, midIndex, lastIndex);
        }
    }

}
