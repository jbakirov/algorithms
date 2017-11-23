package coursera_algorithms.graphs;

import java.util.LinkedList;

/**
 * Created by Baka on 24.11.2016.
 */
public class EdgeWeightedDigraph {
    private final int V;
    private final LinkedList<DirectedEdge>[] adj;
    private int E;

    EdgeWeightedDigraph(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge (DirectedEdge e){
        int v = e.from(), w = e.to();
        adj[v].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        LinkedList<DirectedEdge> list = new LinkedList<>();
        for (int v = 0; v < V; v++){
            for (DirectedEdge e : adj(v)){
                list.add(e);
            }
        }
        return list;
    }

    public int getV(){
        return V;
    }
}
