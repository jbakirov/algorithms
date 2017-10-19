package practice;

import coursera_algorithms.graphs.Graph;

/**
 * Created by Baka on 07.02.2017.
 */
public class DFS {

    private boolean[] visited;

    public void dfs (Graph g, int s){
        visited[s] = true;

        for (int w : g.adj(s)){
            if (!visited[w]) dfs(g, w);
        }
    }

}
