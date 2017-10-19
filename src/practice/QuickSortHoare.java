package practice;

/**
 * Created by Baka on 22.01.2017.
 */
public class QuickSortHoare {

    public static void main(String[] args) {
        int[] a = {5, 3, 18, 6, 12, 2};
        int[] a1 = {3, 3, 3, 3, 3, 3, 3, 3};
        int[] a2 = {4, 5, 99, 3, 4};

        sort(a2);

        for (int i : a2) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {

        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int first, int last) {

        if (first < last) {

            int mid = partition(array, first, last);

            sort(array, first, mid);

            sort(array, mid + 1, last);

        }
    }

    private static int partition(int array[], int first, int last) {

        int x = array[first], i = first - 1, j = last + 1;

        while (true) {

            do {
                j--;
            } while (array[j] > x);

            do {
                i++;
            } while (array[i] < x);

            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            } else
                return j;
        }
    }

}
