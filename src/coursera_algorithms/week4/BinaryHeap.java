package coursera_algorithms.week4;

import java.util.ArrayList;

/**
 * Created by Baka on 27.02.2016.
 */
public class BinaryHeap<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public BinaryHeap(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2*k <= N){
            int j = 2 * k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public void sort (Comparable[] pq){
        for (int k = N/2; k>= 1; k--){
           sink(k);
        }
        while (N > 1){
            exch(1, N--);
            sink(1);
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{5, 3, 2, 54, 2, 1};

        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(10);
        binaryHeap.insert(5);
        binaryHeap.insert(3);
        binaryHeap.insert(2);
        binaryHeap.insert(54);
        binaryHeap.insert(2);
        binaryHeap.insert(1);
        binaryHeap.insert(13);
        binaryHeap.insert(43);
        binaryHeap.insert(7);
        binaryHeap.insert(0);

        binaryHeap.sort(binaryHeap.pq);

        Comparable[] res = (Comparable[]) binaryHeap.pq;

        for (Comparable c : res){
            System.out.println(c);
        }

//        for(int i = 1; i <= binaryHeap.N; i++){
//            System.out.println(binaryHeap.pq[i]);
//        }
    }
}
