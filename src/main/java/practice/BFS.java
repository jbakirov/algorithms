package practice;

import graphs.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Baka on 07.02.2017.
 */
public class BFS {
    private boolean[] visited;
    private int[] distTo;
    private int[] edgeTo;


    public void bfs (Graph g, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        distTo[s] = 0;

        while (!q.isEmpty()){
            int v = q.poll();
            for (int w : g.getNeighbors(v)){
                if (!visited[w]){
                    visited[w] = true;
                    distTo[w] = distTo[v] + 1;
                    edgeTo[w] = v;
                    q.add(w);
                }
            }
        }
    }
}
