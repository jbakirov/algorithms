package coursera_algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Baka on 22.11.2016.
 * Complexity depends on PQ implementation
 * array -         V^2             - optimal for dense graphs
 * binary heap -   E logV          - faster for sparse graphs
 * d-way heap -    E log_1/v (V)   - worth in performance-critical solutions
 * Fibonacci heap  E + V logV      - best in theory, but not worth implementing
 */
public class PrimMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.getV()];
        distTo = new double[G.getV()];
        marked = new boolean[G.getV()];
        pq = new IndexMinPQ<>(G.getV());
        for (int v = 0; v < G.getV(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        for (int v = 0; v < G.getV(); v++) {
            if (!marked[v]) prim(G, v);
        }

    }

    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new LinkedList<>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.add(e);
            }
        }
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }

}
