package practice.practice2;

/**
 * Created by Baka on 01.02.2017.
 */
public class Heap<T extends Comparable<T>> {
    private T[] pq;
    private int N;

    Heap (){
        pq = (T[]) new Comparable[11];
    }

    public void insert (T value){
        pq[++N] = value;
        siftUp(N);
    }

    private void siftUp(int i){
        while (i > 1 && less(i/2, i)){
            exchange(i/2, i);
            i = i/2;
        }
    }

    public T popMax(){
        T max = pq[1];
        exchange(1, N--);
        pq[N+1] = null;
        siftDown(N);

        return max;
    }

    private void siftDown(int i){
        while (i * 2 <= N){
            int j = i * 2;
            if (j < N && less(j, j + 1)) j++;
            if (!less(i, j)) break;
            exchange(i, j);
            i = j;
        }
    }

    private boolean less (int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange (int i, int j){
        T t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
