package khanacademy;

/**
 * Created by Baka on 16.02.2016.
 * lomuto
 */
public class QuickSorting {

    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 6, 7, 5};

        sortG(array, 0, array.length - 1);

        for (int i : array){
            System.out.println(i);
        }
    }

    static int partition(int[] array, int startIndex, int endIndex){
        int bigPointer = startIndex;

        for (int i = startIndex; i < endIndex; i++){
            if (array[i] <= array[endIndex]){
                swap(array, i, bigPointer);
                bigPointer++;
            }
        }
        swap(array, endIndex, bigPointer);
        return bigPointer;
    }

    static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    static void sort(int[] array, int startIndex, int endIndex){
        if (endIndex - startIndex >= 1){
            int pivot = partition(array, startIndex, endIndex);
            sort(array, startIndex, pivot - 1);
            sort(array, pivot + 1, endIndex);
        }
    }



    static void sortG (int[] a, int startIndex, int endIndex){
        if (endIndex <= startIndex) return;

        int part = partitionG(a, startIndex, endIndex);
        sortG(a, startIndex, part-1);
        sortG(a, part+1, endIndex);
    }

    static int partitionG (int[] a, int startIndex, int endIndex){
        int b = startIndex;

        for (int i = startIndex; i < endIndex; i++){
            if (a[i] <= a[endIndex]){
                swap(a, i, b);
                b++;
            }
        }

        swap(a, b, endIndex);
        return b;
    }




    static void sortG2 (int[] a, int startIndex, int endIndex){
        if (endIndex <= startIndex) return;
        int pivot = partitionG2 (a, startIndex, endIndex);
        sortG2(a, startIndex, pivot - 1);
        sortG2(a, pivot + 1, endIndex);
    }

    static int partitionG2 (int[] a, int startIndex, int endIndex){
        int b = startIndex;

        for (int i = startIndex; i < endIndex; i++){
            if (a[i] <= a[endIndex]){
                swap(a, i, b);
                b++;
            }
        }

        swap(a, b, endIndex);
        return b;
    }
}
