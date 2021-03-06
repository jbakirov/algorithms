package coursera_algorithms.graphs;

/**
 * Created by Baka on 22.11.2016.
 */
public class Edge implements Comparable<Edge> {

    private final int v, w;
    private final double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either (){
        return v;
    }

    public int other (int vertex){
        if (vertex == v) return w;
        else return v;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return 1;
        else return 0;
    }

    public double weight(){
        return weight;
    }
}
