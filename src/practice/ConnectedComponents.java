package practice;

import coursera_algorithms.graphs.Graph;

/**
 * Created by Baka on 07.02.2017.
 */
public class ConnectedComponents {
    private boolean[] visited;
    private int[] id;
    int count;

    public void run(Graph g){
        visited = new boolean[g.getV()];
        id = new int[g.getV()];

        for (int i = 0; i < g.getV(); i++){
            if (!visited[i]){
                dfs(g, i);
                count++;
            }
        }
    }

    private void dfs (Graph g, int s){
        visited[s] = true;
        id[s] = count;

        for (int w : g.adj(s)){
            if (!visited[w]) dfs(g, w);
        }
    }
}
