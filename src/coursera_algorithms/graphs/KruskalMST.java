package coursera_algorithms.graphs;

import coursera_algorithms.QuickUnionUF;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Baka on 22.11.2016.
 * minimum spanning tree
 * Kruskal's MST sorts weight and takes minimum weight, if there is no cycle
 *
 * Complexity is E log*E
 */
public class KruskalMST {
    private Queue<Edge> mst = new LinkedList<>();

    public KruskalMST(EdgeWeightedGraph G){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge e : G.edges()){
            pq.add(e);
        }
        QuickUnionUF uf = new QuickUnionUF(G.getV());
        while (!pq.isEmpty() && mst.size() < G.getV() - 1){
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)){
                uf.union(v,w);
                mst.add(e);
            }
        }
    }


    public Iterable<Edge> edges(){
        return mst;
    }
}
