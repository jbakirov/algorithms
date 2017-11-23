package practice.practice7;

/**
 * Created by Baka on 29.01.2017.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 9};
        int[] a1 = {1, 2};

        System.out.println(binarySearch(a1, 2));
    }

    private static int binarySearch(int[] a, int key){

        int s = 0;
        int e = a.length-1;
        int mid;

        while (s <= e){
            mid = (s + e) / 2;

            if (a[mid] == key) return mid;
            else if (a[mid] < key) s = mid + 1;
            else if (a[mid] > key) e = mid - 1;
        }

        return -1;
    }


}
