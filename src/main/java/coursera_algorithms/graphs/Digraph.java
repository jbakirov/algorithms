package coursera_algorithms.graphs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Baka on 16.11.2016.
 */
public class Digraph {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;
    private int[] indegree;

    public Digraph(int n){
        this.V = n;
        this.E = 0;
        indegree = new int[V];
        adj = (LinkedList<Integer>[]) new LinkedList[n];
        for (int i = 0; i < n; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public Digraph(Digraph G){
        this(G.getV());
        this.E = G.E;
        for (int v = 0; v < V; v++){
            this.indegree[v] = G.indegree[v];
        }

        for (int v = 0; v < G.getV(); v++){
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]){
                reverse.push(w);
            }
            for (int w : reverse){
                adj[v].add(w);
            }
        }
    }

    public int getV(){ return V;}

    public void addEdge (int v, int w){
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse (){
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++){
            for (int w : adj(v)){
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

}
