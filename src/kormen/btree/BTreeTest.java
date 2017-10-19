package kormen.btree;

import coursera_algorithms.*;
import coursera_algorithms.BTree;

/**
 * Created by Baka on 15.09.2016.
 */
public class BTreeTest {
    public static void main(String[] args){
        coursera_algorithms.BTree bTree = new BTree();
        bTree.put(1, 1);
        bTree.put(11, 1);
        bTree.put(2, 1);
        bTree.put(23, 1);
        bTree.put(8, 1);
        bTree.put(13, 1);
        bTree.put(27, 1);
        bTree.put(5, 1);

        System.out.println("size: " + bTree.size());
        System.out.println("height: " + bTree.size());
    }
}
