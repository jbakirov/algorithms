package graphs;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Baka on 20.01.2016.
 */
public class GraphAdjMatrix extends Graph {

    private int[][] adjMatrix;

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        if (v >= adjMatrix.length){
            int[][] newAdjMatrix = new int[v*2][v*2];
            for (int i = 0; i < adjMatrix.length; i++){
                for(int j=0; j < adjMatrix.length; j++){
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for (int i = 0; i < adjMatrix[v].length; i++){
            adjMatrix[v][i]=0;
        }
    }

    public void implementAddEdge(int v, int w){
        adjMatrix[v][w] = 1;
    }

    @Override
    public List<Integer> getNeighbors(int v) {

        List<Integer> neighbors = new ArrayList<>();

        for (int i = 0; i < getNumVertices(); i++){
//            if (adjMatrix[v][i] != 0){
            for(int j = 0; i < adjMatrix[v][i]; j++){
                neighbors.add(i);

//                getNeighbors(i); ----- in order to find two-hop neighbors
            }
        }
        return neighbors;
    }


}
