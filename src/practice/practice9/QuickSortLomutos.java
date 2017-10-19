package practice.practice9;

/**
 * Created by Baka on 08.02.2017.
 */
public class QuickSortLomutos {

    public static void main(String[] args) {

    }

    public static void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort (int[] a, int start, int end){
        if (start >= end) return;

        int p = pivot (a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }

    private static int pivot (int[] a, int start, int end){
        int pointer = start;

        for (int i = start; i < end; i++){
            if (a[i] <= a[end]){
                exchange(a, i, pointer);
                pointer++;
            }
        }

        exchange(a, pointer, end);
        return pointer;
    }

    private static void exchange(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
