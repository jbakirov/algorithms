package graphs;

import graphs.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baka on 20.01.2016.
 */
public class GraphAdjList extends Graph {

    private Map<Integer, ArrayList<Integer>> adjListsMap;

    public GraphAdjList(){
        adjListsMap = new HashMap<>();
    }

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        ArrayList<Integer> neighbors = new ArrayList<>();
        adjListsMap.put(v, neighbors);
    }

    public void implementAddEdge (int v, int w){
        (adjListsMap.get(v)).add(w);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return new ArrayList<Integer>(adjListsMap.get(v));
    }

    public List<Integer> getDistance2 (int v){
        List<Integer> twoHop = new ArrayList<>();
        List<Integer> oneHop = adjListsMap.get(v);

        for (Integer i: oneHop){
            twoHop.addAll(getNeighbors(i));
        }

        return twoHop;
    }

}
