package coursera_algorithms;

/**
 * Created by Baka on 24.01.2016.
 */
public class QuickFindUF {

    public int[] id;

    public QuickFindUF(int n){
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public boolean connected (int p, int q){
        return id[p] == id[q];
    }

    public void union (int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);

        quickFindUF.union(4, 9);
        quickFindUF.union(8, 2);
        quickFindUF.union(9, 6);
        quickFindUF.union(6, 0);
        quickFindUF.union(9, 2);
        quickFindUF.union(8, 5);

        for (int i : quickFindUF.id){
            System.out.println(i);
        }
    }

}
