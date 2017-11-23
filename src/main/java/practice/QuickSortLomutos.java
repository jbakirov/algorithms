package practice;

/**
 * Created by Baka on 21.01.2017.
 */
public class QuickSortLomutos {

    public static void main (String[] args){
        int[] array = new int[]{4, 4, 6, 6, 7, 5};

        sort(array);

        for (int i : array){
            System.out.println(i);
        }
    }

    public static void sort (int[] a){
        sort (a, 0, a.length-1);
    }

    public static void sort (int[] a, int start, int end){
        if (start >= end) return;

        int p = partition (a, start, end);
        sort(a, start, p-1);
        sort(a, p + 1, end);
    }

    public static int partition(int[] a, int start, int end){
        int pointer = start;

        for (int i = start; i < end; i++){
            if (a[i] <= a[end]){
                swap(a, i, pointer);
                pointer ++;
            }
        }

        swap(a, end, pointer);
        return pointer;
    }

    static void swap(int[] array, int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

}
