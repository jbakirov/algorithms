package practice.practice8;

/**
 * Created by Baka on 31.01.2017.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 9};
        System.out.println(searchRec(a, 0, a.length-1, 7));
    }

    private static int search(int[] a, int key) {
        int s = 0;
        int e = a.length - 1;
        int mid;

        while (s <= e) {
            mid = (s + e) / 2;

            if (a[mid] == key) return mid;
            else if (a[mid] > key) e = mid - 1;
            else if (a[mid] < key) s = mid + 1;
        }

        return -1;
    }

    private static int searchRec (int[] a, int key, int s, int e){
        if (s > e) return -1;
        int mid = (s + e) / 2;
        if (a[mid] == key) return mid;
        else if (a[mid] > key) return searchRec(a, key, s, mid -1);
        else return searchRec(a, key, mid + 1, e);
    }
}
