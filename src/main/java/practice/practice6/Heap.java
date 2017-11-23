package practice.practice6;

/**
 * Created by Baka on 01.02.2017.
 */
public class Heap<T extends Comparable<T>> {
    private T[] a;
    private int N;

    Heap(int capacity){
        a = (T[]) new Comparable[capacity + 1];
    }

    Heap(){
        a = (T[]) new Comparable[11];
    }

    public void sort (T[] b){
        a = (T[]) new Comparable[b.length + 1];
        N = b.length;
        for (int i = 1; i < a.length; i++){
            a[i] = b[i - 1];
        }

        for (int i = N/2; i >= 1; i--){
            siftDown(i);
        }

        while (N > 1){
            exchange(1, N--);
            siftDown(1);
        }
    }

    public void insert(T value){
        a[++N] = value;
        siftUp(N);
    }

    public T popMax (){
        T max = a[1];
        exchange(1, N--);
        a[N+1] = null;
        siftDown(1);
        return max;
    }

    private void siftDown(int i){
        while (2 * i <= N){
            int j = 2 * i;
            if (j < N && less(j, j + 1)) j++;
            if (!less(i, j)) break;
            exchange(i, j);
            i = j;
        }
    }

    private void siftUp(int i){
        while (i > 1 && less(i/2, i)){
            exchange(i, i/2);
            i = i/2;
        }
    }

    private void exchange (int i, int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private boolean less (int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }
}
