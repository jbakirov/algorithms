package coursera_algorithms.graphs;

/**
 * Created by Baka on 20.11.2016.
 * KosarajuSarirSCC
 * connected components in directed graphs
 */
public class StronglyConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int count;

    public StronglyConnectedComponents(Digraph G){
        marked = new boolean[G.getV()];
        id = new int[G.getV()];
        DepthFirstOrder dfs = new DepthFirstOrder(G);
        for (int v : dfs.reversePost()){
            if (!marked[v]){
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs (Digraph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w: G.adj(v)){
            if (!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected (int v, int w){
        return id[v] == id[w];
    }
}
