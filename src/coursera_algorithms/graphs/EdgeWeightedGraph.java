package coursera_algorithms.graphs;

import java.util.LinkedList;

/**
 * Created by Baka on 22.11.2016.
 */
public class EdgeWeightedGraph {
    private final int V;
    private final LinkedList<Edge>[] adj;
    private int E;                          // number of edges in this graph

    public EdgeWeightedGraph(int V){
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }


    public void addEdge (Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        LinkedList<Edge> list = new LinkedList<>();
        for (int v = 0; v < V; v++){
            for (Edge e : adj(v)){
                list.add(e);
            }
        }
        return list;
    }

    public int getV(){
        return V;
    }
}
