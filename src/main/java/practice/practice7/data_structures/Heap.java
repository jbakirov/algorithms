package practice.practice7.data_structures;

/**
 * Created by Baka on 27.01.2017.
 */
public class Heap<T extends Comparable> {

    private T[] a;
    private int N = 0;

    public Heap(){
        a = (T[]) new Comparable[10];
    }

    public Heap(int capacity){
        a = (T[]) new Comparable[capacity + 1];
    }

    public void insert(T t){
        a[++N] = t;
        swim(N);
    }

    public void swim(int i){
        while (i > 1 && less(i/2, i)){
            exch(i/2, i);
            i = i/2;
        }
    }

    public boolean isEmpty(){return N == 0;}

    public void delMax (){
        T max = a[1];
        exch(1, N--);
        sink(1);
        a[N + 1] = null;
    }

    private void sink(int i){
        while (2 * i <= N){
            int j = 2 * i;
            if (j < N && less(j, j+1)) j++;
            if (!less(i, j)) break;
            exch(i, j);
            i = j;
        }
    }

    public void sort (Comparable[] ar){

        a = (T[]) ar;

        N = a.length-1;
        for (int i = N/2; i >= 0; i--){
            sink(i);
        }

        while (N > 0){
            exch(N--, 0);
            sink(0);
        }
    }

    private boolean less (int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    private void exch (int i, int j){
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
