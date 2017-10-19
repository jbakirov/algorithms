package practice;

import coursera_algorithms.graphs.Graph;

import java.util.Stack;

/**
 * Created by Baka on 07.02.2017.
 */
public class TopologicalSort {

    Stack<Integer> stack = new Stack<>();
    boolean[] visited;

    public void topologicalSort(Graph g){
        visited = new boolean[g.getV()];

        for (int i = 0; i < g.getV(); i++){
            if (!visited[i]){
                dfs(g, i);
            }
        }
    }

    private void dfs (Graph g, int s){
        visited[s] = true;

        for (int i : g.adj(s)){
            if (!visited[i]) dfs(g, i);
        }

        stack.push(s);
    }

}
