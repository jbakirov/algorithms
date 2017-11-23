package graphs_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baka on 24.01.2016.
 */
public class GraphAdjMatrix extends Graph {

    private int[][] adjMatrix;
    private int defaultNumberOfVertices = 5;

    GraphAdjMatrix() {
        adjMatrix = new int[defaultNumberOfVertices][defaultNumberOfVertices];
    }

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        if (v >= adjMatrix.length) {
            int[][] newAdjMatrix = new int[v * 2][v * 2];
            for (int i = 0; i < adjMatrix[v].length; i++){
                for (int j = 0; j < adjMatrix[v].length; j++){
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for (int i = 0; i < adjMatrix[v].length; i++) {
            adjMatrix[v][i] = 0;
        }
    }

    public void implementAddEdge(int v, int w){
        adjMatrix[v][w] += 1;
    }

    @Override
    public List<Integer> getNeighbors(int v) {

        List<Integer> neighbors = new ArrayList<>();

        for (int i =0 ; i < getNumVertices(); i++){
            for (int j=0; j < adjMatrix[v][i]; j++){
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public List<Integer> getInNeighbors (int v){
        List<Integer> inNeighbors = new ArrayList<>();

        for (int i= 0; i < getNumVertices(); i++){
            for (int j = 0; j < adjMatrix[i][v]; j++){
                inNeighbors.add(i);
            }
        }

        return inNeighbors;
    }


}
