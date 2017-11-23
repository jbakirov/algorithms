package coursera_algorithms.graphs;


import java.util.Stack;

/**
 * Created by Baka on 13.11.2016.
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        dfs(G, s);
    }

    public DepthFirstSearch(Graph G, int s, int k) {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        dfs(G, s, k);
    }

    public DepthFirstSearch(Digraph G) {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        dfs(G, G.getV());
    }

    private void dfs(Digraph G, int v) {
        marked[s] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    private void dfs(Graph G, int s, int k) {
        marked[s] = true;
        if (k == s) return;

        for (int w : G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w, k);
                edgeTo[w] = s;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
