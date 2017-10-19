package coursera_algorithms.graphs;

import java.util.Stack;

/**
 * Created by Baka on 24.11.2016.
 */
public class EdgeWeightedDirectedCycle {
    private boolean[] marked;
    private DirectedEdge[] edgeTo;
    private boolean[] onStack;
    private Stack<DirectedEdge> cycle;

    public EdgeWeightedDirectedCycle(EdgeWeightedDigraph G){
        marked = new boolean[G.getV()];
        onStack = new boolean[G.getV()];
        edgeTo = new DirectedEdge[G.getV()];
        for (int v = 0; v < G.getV(); v++){
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(EdgeWeightedDigraph G, int v){
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)){
            int w = e.to();

            if (cycle != null) return;

            else if (!marked[w]){
                edgeTo[w] = e;
                dfs(G, w);
            }

            else if (onStack[w]){
                cycle = new Stack<DirectedEdge>();

                DirectedEdge f = e;
                while (f.from() != w){
                    cycle.push(f);
                    f = edgeTo[f.from()];
                }
                cycle.push(f);

                return;
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<DirectedEdge> cycle(){
        return cycle;
    }
}
