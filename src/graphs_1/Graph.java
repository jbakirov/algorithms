package graphs_1;

import java.util.List;

/**
 * Created by Baka on 24.01.2016.
 */
public abstract class Graph {

    private int numVertices;
    private int numEdges;

    public Graph() {
        numVertices = 0;
        numEdges = 0;
    }

    public void addVertex() {
        implementAddVertex();
        numVertices++;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public abstract void implementAddVertex();

    public abstract List<Integer> getNeighbors(int v);


}
