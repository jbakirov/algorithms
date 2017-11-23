package practice.practice9;

import practice.practice5.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baka on 08.02.2017.
 */
public class BucketSort {
    public static void main(String[] args) {

    }

    public static void sort(Integer[] a){

    }

    private static void sort(Integer[] a, int bucketSize){
        if (a.length == 0) return;

        int min = a[0];
        int max = a[0];

        for (int i = 1; i < a.length; i++){
            if (a[i] < min) min = a[i];
            else if (a[i] > max) max = a[i];
        }

        int bucketCount = (max - min) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++){
            buckets.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < a.length; i++){
            buckets.get((a[i] - min) / bucketSize).add(a[i]);
        }

        int current = 0;
        for (int i = 0; i < buckets.size(); i++){
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            new InsertionSort().sort(bucketArray);
            for (int j = 0; j < bucketArray.length; j++){
                a[current++] = bucketArray[j];
            }
        }
    }
}
