package practice.practice4;

/**
 * Created by Baka on 23.01.2017.
 */
public class QuickSortLomutos {
    public static void main(String[] args) {
        int[] a = {23, 19, 2, 18, 33, 1, 9};
        sort(a);

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (start >= end) return;

        int p = partition (a, start, end);
        sort(a, start, p-1);
        sort(a, p + 1, end);
    }

    public static int partition(int[] a, int start, int end){
        int pointer = start;

        for (int i = start; i < end; i++){
            if (a[end] >= a[i]){
                swap(a, pointer, i);
                pointer++;
            }
        }

        swap(a, end, pointer);
        return pointer;
    }

    public static void swap (int [] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
