package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baka on 08.02.2017.
 */
public class SkipList<E extends Comparable<E>> {

    int size = 0;
    int maxLevel = 0;
    Node<E> head;

    private static final float PROBABILITY = 0.5f;

    public SkipList(){
        head = new Node(null);
        head.nextNodes.add(null);
    }

    Node<E> getHead(){
        return head;
    }

    public boolean add (E v){
        if (contains(v)) return false;
        size ++;
        int level = 0;
        while (Math.random() < PROBABILITY){
            level++;
        }

        while (level > maxLevel){
            head.nextNodes.add(null);
            maxLevel++;
        }

        Node newNode = new Node(v);
        Node cur = head;

        do{
            cur = findNext(v, cur, level);
            newNode.nextNodes.add(0, cur.nextNodes.get(level));
            cur.nextNodes.set(level, newNode);
        } while (level-- > 0);
        return true;
    }

    private Node findNext (E v, Node cur, int level){
        Node next = (Node) cur.nextNodes.get(level);
        while (next != null){
            E val = (E) next.value;
            if (v.compareTo(val) < 0) break;
            cur = next;
            next = (Node) cur.nextNodes.get(level);
        }
        return cur;
    }

    private boolean contains (E v){
        Node n = find(v);
        return n != null && n.value != null && v.compareTo((E) n.value) == 0;
    }

    private Node find (E v){
        return find(v, head, maxLevel);
    }

    private Node find (E e, Node cur, int level){
        do{
            cur = findNext(e, cur, level);
        } while (level-- > 0);
        return cur;
    }

    class Node <E> {
        E value;
        public List<Node<E>> nextNodes;

        Node(E val) {
            value = val;
            nextNodes = new ArrayList<>();
        }
    }
}
