package practice.practice9;

/**
 * Created by Baka on 09.02.2017.
 */
public class Heap<E extends Comparable<E>> {

    private E[] pq;
    private int N;

    Heap() {
        pq = (E[]) new Object[10+1];
        N = 0;
    }

    public void add(E value) {
        pq[++N] = value;
        siftUp(N);
    }

    public E pop(){
        E r = pq[1];
        exchange(1, N--);
        pq[N + 1] = null;
        siftDown(N);

        return r;
    }

    public E peek (){
        return pq[1];
    }

    private void siftDown(int n){
        while (2 * n <= N){
            int j = 2 * n;
            if (j < N && less(j+1, j)) j++;
            if (less(n, j)) break;
            exchange(j, n);
            n = j;
        }
    }

    private void siftUp(int n){
        while (n > 1 && less(n, n/2)){
            exchange(n/2, n);
            n = n/2;
        }
    }

    private void exchange (int i, int j){
        E t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less (int i , int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
}
