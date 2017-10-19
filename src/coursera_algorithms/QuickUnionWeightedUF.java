package coursera_algorithms;

/**
 * Created by Baka on 24.01.2016.
 */
public class QuickUnionWeightedUF {

    private int[] id;
    private int[] size;

    public QuickUnionWeightedUF(int n){
        id = new int[n];
        for (int i=0; i < n; i++){
            id[i] = i;
        }
    }

    private int root (int i){
        while (i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected  (int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root (p);
        int j = root (q);

        if (size[i] < size[j]){
            id[i] = j;
            size[j] += size[i];
        }else {
            id[j] = i;
            size[i] += size[j];
        }
    }

    public static void main(String[] args) {

    }

}
