package stepic;

/**
 * Created by Baka on 12.02.2016.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(array, 10));
    }

    static int binarySearch(int[] array, int key) {
        int min = 0;
        int max = array.length - 1;
        int comp = 0;

        while (min <= max) {
            comp = (max + min) / 2;

            if (array[comp] == key) {
                return comp;
            } else if (array[comp] < key) {
                min = comp + 1;
            } else if (array[comp] > key) {
                max = comp - 1;
            }
        }

        return -1;
    }

}
