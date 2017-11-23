package kormen;

import java.util.Arrays;

/**
 * Created by Baka on 22.03.2016.
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {4, 3, 1, 65, 31, 23, 1, 0, 8};
        radixSort(array);

        for (int i : array){
            System.out.println(i);
        }
    }

    /**
     * The main function to that sorts a[] of size n using Radix Sort
     *
     * @param a
     */
    public static void radixSort(int[] a) {
        // Find the maximum number to know number of digits
        int m = getMax(a, a.length);

        // Do counting sort for every digit. Not that instead of
        // passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(a, a.length, exp);
    }

    /**
     * A function to do counting sort of a[] according to
     * the digit represented by exp.
     *
     * @param a   array name
     * @param n   the legth of array
     * @param exp digit
     */
    public static void countSort(int[] a, int n, int exp) {

        int[] output = new int[n]; //output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(a[i] / exp) % 10]++;


        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            output[count[(a[i] / exp) % 10] - 1] = a[i];
            count[(a[i] / exp) % 10]--;
        }


        //Copy the output array to a[], so that a[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            a[i] = output[i];
    }

    /**
     * a utility function to get maximum value in array
     *
     * @param a array name
     * @param n array length
     * @return
     */
    public static int getMax(int[] a, int n) {
        int mx = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > mx) mx = a[i];
        }
        return mx;
    }

}
