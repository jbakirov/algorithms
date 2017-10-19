package kormen.SkipList_easierToUnderstand;

import java.util.Iterator;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Baka on 21.12.2016.
 */
public class SkipListIterator<E extends Comparable<E>> implements Iterator<E> {
    SkipList<E> list;
    SkipListNode<E> current;

    public SkipListIterator(SkipList<E> list) {
        this.list = list;
        this.current = list.getHead();
    }

    public boolean hasNext() {
        return current.nextNodes.get(0) != null;
    }

    public E next() {
        current = (SkipListNode<E>)current.nextNodes.get(0);
        return (E)current.getValue();
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}
