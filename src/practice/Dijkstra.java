package practice;

import coursera_algorithms.graphs.DirectedEdge;
import coursera_algorithms.graphs.EdgeWeightedDigraph;
import coursera_algorithms.graphs.Graph;

import java.util.PriorityQueue;

/**
 * Created by Baka on 08.02.2017.
 */
public class Dijkstra {
    PriorityQueue pq = new PriorityQueue();
    double[] distTo;
    DirectedEdge[] edgeTo;

    Dijkstra(EdgeWeightedDigraph g, int v) {
        distTo = new double[g.getV()];
        edgeTo = new DirectedEdge[g.getV()];

        for (int i = 0; i < g.getV(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[v] = 0.0;

        pq.add(v);

        while (!pq.isEmpty()){
            int s = (int) pq.poll();
            for (DirectedEdge i : g.adj(s)){
                relax (i);
            }
        }
    }

    private void relax(DirectedEdge e){
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()){
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)){
//                pq.remove()
            }
        }
    }



}
