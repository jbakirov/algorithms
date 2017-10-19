package practice.practice8.data_structures;

/**
 * Created by Baka on 31.01.2017.
 */
public class Heap<T extends Comparable> {
    private T[] a;
    private int N = 0;

    Heap() {
        a = (T[]) new Object[10];
    }

    Heap(int capacity) {
        a = (T[]) new Object[capacity];
    }

    public void sort (T[] b){
        a = (T[]) new Object[b.length + 1];
        for (int i = 0; i < b.length; i++){
            a[i+1] = b[i];
        }

        int n = a.length - 1;

        for (int i = n/2; i >= 1; i--){
            siftDown(i);
        }

        while (n > 1){
            exchange(1, n--);
            siftDown(1);
        }
    }

    public void add(T v) {
        a[++N] = v;
        siftUp(N);
    }

    private void siftUp(int N) {

        while (N > 1 && less(N / 2, N)) {
            exchange(N / 2, N);
            N = N/2;
        }
    }

    private T pop (){
        T max = a[1];
        exchange(1, N--);
        a[N+1] = null;
        siftDown(1);
        return max;
    }

    private void siftDown(int i){
        while (i * 2 <= N){
            int j = i * 2;
            if (j < N && less(j, j+1)) j++;
            if (!less(i, j)) break;
            exchange(j, i);
            i = j;
        }
    }

    private boolean less(int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private void exchange(int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
