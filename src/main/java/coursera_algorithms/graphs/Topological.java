package coursera_algorithms.graphs;

/**
 * Created by Baka on 24.11.2016.
 * for weighted directed edges O(V+E)
 */
public class Topological {
    private Iterable<Integer> order;
    private int[] rank;

    public Topological(Digraph G){
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            rank = new int[G.getV()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
        }
    }

    public Topological(EdgeWeightedDigraph G){
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean hasOrder(){
        return order != null;
    }

    public int rank(int v){
        validateVertex(v);
        if (hasOrder()) return rank[v];
        else return -1;
    }

    private void validateVertex(int v){
        int V = rank.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
