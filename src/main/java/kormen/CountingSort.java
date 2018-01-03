package kormen;

/**
 * Created by Baka on 21.03.2016.
 */
public class CountingSort {

    /*
    known also as Histogram Sort
    stable
    O(n + k);
    k is the biggest number in the array
     */

    private static int[] c;

    public void sort(int[] a, int[] b, int k){
        c = new int[k + 1];

        for (int i = 0; i <= k; i++){
            c[i] = 0;
        }

        for (int i = 0; i < a.length; i++){
            c[a[i]] = c[a[i]] + 1;
//            System.out.println(c[a[i]]);
        }

        for (int i = 1; i <= k; i++){
            c[i] = c[i] + c[i-1];
        }

        for (int i = a.length - 1; i >= 0; i--){
            b[c[a[i]] - 1] = a[i];
            c[a[i]] = c[a[i]]- 1;
        }
    }

    public static int[] sort(int[] array) {

        // array to be sorted in, this array is necessary
        // when we sort object datatypes, if we don't,
        // we can sort directly into the input array
        int[] aux = new int[array.length];

        // find the smallest and the largest value
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        // init array of frequencies
        int[] counts = new int[max - min + 1];

        // init the frequencies
        for (int i = 0;  i < array.length; i++) {
            counts[array[i] - min]++;
        }

        // recalculate the array - create the array of occurences
        counts[0]--;
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }

    /*
      Sort the array right to the left
      1) Look up in the array of occurences the last occurence of the given value
      2) Place it into the sorted array
      3) Decrement the index of the last occurence of the given value
      4) Continue with the previous value of the input array (goto set1),
         terminate if all values were already sorted
    */
        for (int i = array.length - 1; i >= 0; i--) {
            aux[counts[array[i] - min]--] = array[i];
        }

        return aux;
    }

    public static void main(String[] args) {
        int a[] = {2, 5, 3, 0, 2, 3, 0, 3, 7};
        int b[] = new int[a.length];

        new CountingSort().sort(a, b, 7);

        for (int i : b){
            System.out.println(i);
        }
    }


    public void countingSort(int[] a) {
        int[] c = new int[a.length];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        int[] counts = new int[max - min + 1];

        for (int i = 0; i < a.length; i++) {
            counts[a[i]-min] ++;
        }

        counts[0]--;
        for (int i = 1; i < a.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }

        for (int i = 0; i < a.length; i++) {
            c[counts[a[i]-min]--] = a[i];
        }
    }

}
