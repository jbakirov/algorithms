package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baka on 09.02.2017.
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] a = {5, 12, 2, 19, 5, 3};
    }

    public void sort(int[] a, int bucketSize){
        int min = a[0];
        int max = a[0];

        for (int i = 1; i < a.length; i++){
            if (a[i] > max) max = a[i];
            else if (a[i] < min) min = a[i];
        }

        int buckets = (max - min) / bucketSize + 1;

        List<ArrayList<Integer>> bucket = new ArrayList<>(buckets);

        for (int i = 0; i < a.length; i++){
            bucket.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < a.length; i++){
            bucket.get((a[i] - min) / bucketSize).add(a[i]);
        }

        int count = 0;
        for (int i = 0; i < bucket.size(); i++){
            Integer[] ar = new Integer[bucket.get(i).size()];
            ar = bucket.get(i).toArray(ar);
//            new InsertionSort().sort(ar); //commented because ar is Integer[], needs int[]
            for (int j = 0; j < ar.length; j++){
                a[count++] = ar[i];
            }
        }
    }
}
