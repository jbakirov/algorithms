package coursera_algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Baka on 13.11.2016.
 */
public class BreadthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int s;

    public BreadthFirstSearch(Graph g, int s){
        marked = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        this.s = s;

        bfs(g, s);
    }

    public BreadthFirstSearch(Graph g, int s, int k){
        marked = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        distTo = new int[g.getV()];
        this.s = s;
    }

    private void bfs(Graph g, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        distTo[s] = 0;

        while (!q.isEmpty()){
            int v = q.poll();
            for (int w : g.adj(v)){
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.add(w);
                }
            }
        }
    }


    private void bfs (Graph g, int s, int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        distTo[s] = 0;

        while (!q.isEmpty()){
            int v = q.poll();
            for (int w : g.adj(v)){
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    if (w == k) return;
                    q.add(w);
                }
            }
        }
    }

    private void bfs (Graph G, Iterable<Integer> sources){
        Queue<Integer> q = new LinkedList<>();
        for (int s : sources){
            q.add(s);
            marked[s] = true;
            distTo[s] = 0;
        }

        while (!q.isEmpty()){
            int v = q.poll();
            for (int w : G.adj(v)){
                if (!marked[w]){
                    marked[w] = true;
                    q.add(w);
                    distTo[w] = distTo[v] + 1;
                    edgeTo[w] = v;
                }
            }
        }
    }

    private boolean hasPathTo (int v){
        return marked[v];
    }

    public Stack pathTo (int k){
        if (!marked[k]) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = k; x != s; x = edgeTo[k])
            path.push(x);
        path.push(s);
        return path;
    }


}
