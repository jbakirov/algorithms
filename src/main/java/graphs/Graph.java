package graphs;

import java.util.List;

/**
 * Created by Baka on 20.01.2016.
 */
public abstract class Graph {
    private int numVertices;
    private int numEdges;

    public Graph(){
        numVertices = 0;
        numEdges = 0;
    }

    public int getNumVertices(){
        return numVertices;
    }

    public int getNumEdges(){
        return numEdges;
    }

    public int addVertex(){
        implementAddVertex();
        numVertices++;
        return (getNumVertices()-1);
    }

    public abstract void implementAddVertex();

    public abstract List<Integer> getNeighbors(int v);
}
