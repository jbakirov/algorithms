package prep;

/**
 * Created by Baka on 16.10.2016.
 * <p/>
 * Binary Heap
 * insert - logn; del max - logn; max - 1;
 */
public class MyHeap<K extends Comparable> {

    private K[] pq;
    private int N;


    MyHeap() {

    }

    MyHeap(int capacity) {
        pq = (K[]) new Comparable[capacity + 1];
    }

    public void sort(Comparable[] a){
        int N = a.length;
        for (int i = N/2; i >= 1; i--){
            sink(i);
        }

        while (N > 1){
            exch(1, N--);
            sink(1);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(K key) {
        pq[++N] = key;
        swim(N);
    }

    public K delMax() {
        K max = pq[1];
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

        while (2 * k <= N) {
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
        K t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

}