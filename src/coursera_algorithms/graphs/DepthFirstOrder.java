package coursera_algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Baka on 18.11.2016.
 * aka Topological Sort
 * O (V + E)
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> reversePost;
    private int[] pre;
    private int[] post;
    private Queue<Integer> preorder;
    private Queue<Integer> postorder;
    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(Digraph G){
        reversePost = new Stack<>();
        marked = new boolean[G.getV()];
        for (int v = 0; v < G.getV(); v++){
            if (!marked[v]) dfs(G, v);
        }
    }

    public DepthFirstOrder(EdgeWeightedDigraph G){
        pre = new int[G.getV()];
        post = new int[G.getV()];
        postorder = new LinkedList<>();
        preorder = new LinkedList<>();
        marked = new boolean[G.getV()];
        for (int v = 0; v < G.getV(); v++)
            if (!marked[v]) dfs(G, v);
    }

    private void dfs(EdgeWeightedDigraph G, int v){
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.add(v);
        for (DirectedEdge e : G.adj(v)){
            int w = e.to();
            if (!marked[w]){
                dfs(G, w);
            }
        }
        postorder.add(v);
        post[v] = postCounter++;
    }

    private void dfs(Digraph G,  int v){
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.add(v);
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
        postorder.add(v);
        post[v] = postCounter++;
        reversePost.push(v);
    }

    public int pre(int v){
        validateVertex(v);
        return pre[v];
    }

    public int post(int v){
        validateVertex(v);
        return post[v];
    }

    public Iterable<Integer> post(){
        return postorder;
    }

    public Iterable<Integer> pre(){
        return preorder;
    }

    private void validateVertex(int v){
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
