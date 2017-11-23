package coursera_algorithms.graphs;

/**
 * Created by Baka on 24.11.2016.
 * depends on priority queue
 *      - unordered array: V^2          -dense graphs
 *      - binary heap: E logV           -sparse graphs
 *      - d-way heap: E log_E/V V       -performance critical situations
 *      - Fibonacci heap: E + V log V   -best in theory
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s){
        edgeTo = new DirectedEdge[G.getV()];
        distTo = new double[G.getV()];
        pq = new IndexMinPQ<>(G.getV());

        for (int v = 0; v < G.getV(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()){
            int v = pq.delMin();
            for (DirectedEdge e : G.adj(v))
                relax(e);
        }
    }

    private void relax (DirectedEdge e){
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()){
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }
}
