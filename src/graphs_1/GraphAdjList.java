package graphs_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baka on 24.01.2016.
 */
public class GraphAdjList extends Graph {

    private Map<Integer, ArrayList<Integer>> adjList;

    GraphAdjList(){
        adjList = new HashMap<>();
    }

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        ArrayList<Integer> neighbors = new ArrayList<>();
        adjList.put(v, neighbors);
    }

    private void implementAddEdge (int v, int e){
        adjList.get(v).add(e);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return new ArrayList<>(adjList.get(v));
    }


}
