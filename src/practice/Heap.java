package practice;

/**
 * Created by Baka on 18.11.2016.
 */
public class Heap<K extends Comparable<K>> {

    private K[] pq;
    private int N;

    public Heap(int capacity) {
        pq = (K[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(K o){
        pq[++N] = o;
        siftUp(N);
    }

    public void siftUp (int i){
        while (i > 1 && less(i/2, i)){
            exchange(i/2, i);
            i = i/2;
        }
    }

    public void delMax (){
        exchange(1, N--);
        pq[N + 1] = null;
        siftDown(1);
    }

    private void siftDown(int i){
        while (i * 2 <= N){
            int j = 2 * i;
            if (j < N && less(j, j+1)) j++;
            if (!less(i, j)) break;
            exchange(i, j);
            i = j;
        }
    }

    private boolean less (int i, int a){
        return pq[i].compareTo(pq[a]) < 0;
    }

    private void exchange (int i, int a){
        K tmp = pq[i];
        pq[i] = pq[a];
        pq[a] = tmp;
    }

    public K poll (){
        K max = pq[1];
        delMax();
        return max;
    }

    public void sort(Comparable[] a){
        int n = a.length;

        for (int i = n/2; i >= 1; i--){
            siftDown(i);
        }

        while (n > 1){
            exchange(1, n--);
            siftDown(1);
        }
    }
}
