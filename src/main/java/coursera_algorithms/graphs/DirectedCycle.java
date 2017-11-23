package coursera_algorithms.graphs;

import java.util.Stack;

/**
 * Created by Baka on 18.11.2016.
 * detects if there is a cycle
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        onStack = new boolean[G.getV()];
        for (int v = 0; v < G.getV(); v++) {
            if (!marked[v] && cycle == null) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (cycle != null) return; //short circuit if directed cycle found
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }

                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private boolean check() {
        if (hasCycle()) {
            int first = -1;
            int last = -1;

            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last){
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
