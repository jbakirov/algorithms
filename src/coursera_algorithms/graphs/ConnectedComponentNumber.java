package coursera_algorithms.graphs;

/**
 * Created by Baka on 15.11.2016.
 * connected components in undirected graphs
 */
public class ConnectedComponentNumber {

    private boolean[] marked;
    private int[] id;
    private int count;

    ConnectedComponentNumber(Graph g){
        marked = new boolean[g.getV()];
        id = new int[g.getV()];

        for (int v = 0; v < g.getV(); v++){
            if (!marked[v]){
                dfs(g, v);
                count++;
            }
        }
    }

    public int count(){
        return count;
    }

    public int id(int v){
        return v;
    }

    public void dfs(Graph g, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)){
            if (!marked[w])
                dfs(g, w);
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
}
