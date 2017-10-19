package coursera_algorithms.graphs;

import java.util.LinkedList;

/**
 * Created by Baka on 13.11.2016.
 */
public class Graph {
    private final int V;
    private LinkedList<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    /*
     * return adjacent list to vector v
     */
    public Iterable<Integer> adj (int v){
        return adj[v];
    }

    public int getV(){
        return V;
    }


}
