package kormen.jgraph;

import java.util.*;

/**
 * Created by Baka on 17.05.2016.
 */
public class FibonacciHeap<T> {

    private static final double oneOverLogPhi = 1.0 / Math.log((1.0 + Math.sqrt(5.0) / 2.0));

    /* Points to the minimum node in the heap */
    private FibonacciHeapNode<T> minNode;

    /* Number of nodes in the heap */
    private int nNodes;

    public FibonacciHeap() {
    }

    /**
     * Test if the Fibonacci heap is empty or not. Returns true if the heap
     * is empty, false otherwise.
     * <p> Running time: O(1) actual</p>
     *
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return minNode == null;
    }

    /**
     * Removes all elements from this heap
     */
    public void clear() {
        minNode = null;
        nNodes = 0;
    }


    /**
     * Deletes a node from the heap given the reference to the node. The trees
     * in the heap will be consolidated, if necessary. This operation may fail
     * to remove the correct element if there are nodes with key value
     * -Infinity.
     * <p/>
     * <p>Running time: O(log n) amortized</p>
     *
     * @param x node to remove from heap
     */

    public void delete(FibonacciHeapNode<T> x) {
        // make x as small as possible
        decreaseKey(x, Double.NEGATIVE_INFINITY);

        // remove the smallest, which decreases n also
        removeMin();
    }

    /**
     * Decreases the key value for a heap node, given the new value to take on.
     * The structure of the heap may be changed and will not be consolidated.
     * <p/>
     * <p>Running time: O(1) amortized</p>
     *
     * @param x node to decrease the key of
     * @param k new key value for node x
     * @throws IllegalArgumentException Thrown if k is larger than x.key
     *                                  value.
     */
    public void decreaseKey(FibonacciHeapNode<T> x, double k) {
        if (k > x.key)
            throw new IllegalArgumentException("decreaseKey() got larger key");

        x.key = k;

        FibonacciHeapNode<T> y = x.parent;

        if ((y != null) && (x.key < y.key)) {
            cut(x, y);
            cascadingCut(y);
        }

        if (x.key < minNode.key) {
            minNode = x;
        }
    }


    /**
     * Inserts a new data element into the heap. No heap consolidation is
     * performed at this time, the new node is simply inserted into the root
     * list of this heap.
     *
     * <p>Running time: O(1) actual</p>
     *
     * @param node new node to insert into heap
     * @param key key value associated with data object
     */
    public void insert(FibonacciHeapNode<T> node, double key)
    {
        node.key = key;

        // concatenate node into min list
        if (minNode != null) {
            node.left = minNode;
            node.right = minNode.right;
            minNode.right = node;
            node.right.left = node;

            if (key < minNode.key) {
                minNode = node;
            }
        } else {
            minNode = node;
        }

        nNodes++;
    }


    /**
     * Returns the smallest element in the heap. This smallest element is the
     * one with the minimum key value.
     *
     * <p>Running time: O(1) actual</p>
     *
     * @return heap node with the smallest key
     */
    public FibonacciHeapNode<T> min()
    {
        return minNode;
    }



    /**
     * Removes the smallest element from the heap. This will cause the trees in
     * the heap to be consolidated, if necessary.
     *
     * <p>Running time: O(log n) amortized</p>
     *
     * @return node with the smallest key
     */
    public FibonacciHeapNode<T> removeMin()
    {
        FibonacciHeapNode<T> z = minNode;

        if (z != null) {
            int numKids = z.degree;
            FibonacciHeapNode<T> x = z.child;
            FibonacciHeapNode<T> tempRight;

            // for each child of z do...
            while (numKids > 0) {
                tempRight = x.right;

                // remove x from child list
                x.left.right = x.right;
                x.right.left = x.left;

                // add x to root list of heap
                x.left = minNode;
                x.right = minNode.right;
                minNode.right = x;
                x.right.left = x;

                // set parent[x] to null
                x.parent = null;
                x = tempRight;
                numKids--;
            }

            // remove z from root list of heap
            z.left.right = z.right;
            z.right.left = z.left;

            if (z == z.right) {
                minNode = null;
            } else {
                minNode = z.right;
                consolidate();
            }

            // decrement size of heap
            nNodes--;
        }

        return z;
    }


    /**
     * Returns the size of the heap which is measured in the number of elements
     * contained in the heap.
     *
     * <p>Running time: O(1) actual</p>
     *
     * @return number of elements in the heap
     */
    public int size()
    {
        return nNodes;
    }


    /**
     * Joins two Fibonacci heaps into a new one. No heap consolidation is
     * performed at this time. The two root lists are simply joined together.
     *
     * <p>Running time: O(1) actual</p>
     *
     * @param h1 first heap
     * @param h2 second heap
     *
     * @return new heap containing h1 and h2
     */
    public static <T> FibonacciHeap<T> union(
            FibonacciHeap<T> h1,
            FibonacciHeap<T> h2)
    {
        FibonacciHeap<T> h = new FibonacciHeap<T>();

        if ((h1 != null) && (h2 != null)) {
            h.minNode = h1.minNode;

            if (h.minNode != null) {
                if (h2.minNode != null) {
                    h.minNode.right.left = h2.minNode.left;
                    h2.minNode.left.right = h.minNode.right;
                    h.minNode.right = h2.minNode;
                    h2.minNode.left = h.minNode;

                    if (h2.minNode.key < h1.minNode.key) {
                        h.minNode = h2.minNode;
                    }
                }
            } else {
                h.minNode = h2.minNode;
            }

            h.nNodes = h1.nNodes + h2.nNodes;
        }

        return h;
    }




    /**
     * Creates a String representation of this Fibonacci heap.
     *
     * @return String of this.
     */
    public String toString()
    {
        if (minNode == null) {
            return "FibonacciHeap=[]";
        }

        // create a new stack and put root on it
        Stack<FibonacciHeapNode<T>> stack = new Stack<FibonacciHeapNode<T>>();
        stack.push(minNode);

        StringBuffer buf = new StringBuffer(512);
        buf.append("FibonacciHeap=[");

        // do a simple breadth-first traversal on the tree
        while (!stack.empty()) {
            FibonacciHeapNode<T> curr = stack.pop();
            buf.append(curr);
            buf.append(", ");

            if (curr.child != null) {
                stack.push(curr.child);
            }

            FibonacciHeapNode<T> start = curr;
            curr = curr.right;

            while (curr != start) {
                buf.append(curr);
                buf.append(", ");

                if (curr.child != null) {
                    stack.push(curr.child);
                }

                curr = curr.right;
            }
        }

        buf.append(']');

        return buf.toString();
    }



    /**
     * Performs a cascading cut operation. This cuts y from its parent and then
     * does the same for its parent, and so on up the tree.
     *
     * <p>Running time: O(log n); O(1) excluding the recursion</p>
     *
     * @param y node to perform cascading cut on
     */
    protected void cascadingCut(FibonacciHeapNode<T> y)
    {
        FibonacciHeapNode<T> z = y.parent;

        // if there's a parent...
        if (z != null) {
            // if y is unmarked, set it marked
            if (!y.mark) {
                y.mark = true;
            } else {
                // it's marked, cut it from parent
                cut(y, z);

                // cut its parent as well
                cascadingCut(z);
            }
        }
    }


    protected void consolidate()
    {
        int arraySize =
                ((int) Math.floor(Math.log(nNodes) * oneOverLogPhi)) + 1;

        List<FibonacciHeapNode<T>> array =
                new ArrayList<FibonacciHeapNode<T>>(arraySize);

        // Initialize degree array
        for (int i = 0; i < arraySize; i++) {
            array.add(null);
        }

        // Find the number of root nodes.
        int numRoots = 0;
        FibonacciHeapNode<T> x = minNode;

        if (x != null) {
            numRoots++;
            x = x.right;

            while (x != minNode) {
                numRoots++;
                x = x.right;
            }
        }

        // For each node in root list do...
        while (numRoots > 0) {
            // Access this node's degree..
            int d = x.degree;
            FibonacciHeapNode<T> next = x.right;

            // ..and see if there's another of the same degree.
            for (;;) {
                FibonacciHeapNode<T> y = array.get(d);
                if (y == null) {
                    // Nope.
                    break;
                }

                // There is, make one of the nodes a child of the other.
                // Do this based on the key value.
                if (x.key > y.key) {
                    FibonacciHeapNode<T> temp = y;
                    y = x;
                    x = temp;
                }

                // FibonacciHeapNode<T> y disappears from root list.
                link(y, x);

                // We've handled this degree, go to next one.
                array.set(d, null);
                d++;
            }

            // Save this node for later when we might encounter another
            // of the same degree.
            array.set(d, x);

            // Move forward through list.
            x = next;
            numRoots--;
        }

        // Set min to null (effectively losing the root list) and
        // reconstruct the root list from the array entries in array[].
        minNode = null;

        for (int i = 0; i < arraySize; i++) {
            FibonacciHeapNode<T> y = array.get(i);
            if (y == null) {
                continue;
            }

            // We've got a live one, add it to root list.
            if (minNode != null) {
                // First remove node from root list.
                y.left.right = y.right;
                y.right.left = y.left;

                // Now add to root list, again.
                y.left = minNode;
                y.right = minNode.right;
                minNode.right = y;
                y.right.left = y;

                // Check if this is a new min.
                if (y.key < minNode.key) {
                    minNode = y;
                }
            } else {
                minNode = y;
            }
        }
    }


    /**
     * The reverse of the link operation: removes x from the child list of y.
     * This method assumes that min is non-null.
     *
     * <p>Running time: O(1)</p>
     *
     * @param x child of y to be removed from y's child list
     * @param y parent of x about to lose a child
     */
    protected void cut(FibonacciHeapNode<T> x, FibonacciHeapNode<T> y)
    {
        // remove x from childlist of y and decrement degree[y]
        x.left.right = x.right;
        x.right.left = x.left;
        y.degree--;

        // reset y.child if necessary
        if (y.child == x) {
            y.child = x.right;
        }

        if (y.degree == 0) {
            y.child = null;
        }

        // add x to root list of heap
        x.left = minNode;
        x.right = minNode.right;
        minNode.right = x;
        x.right.left = x;

        // set parent[x] to nil
        x.parent = null;

        // set mark[x] to false
        x.mark = false;
    }


    /**
     * Make node y a child of node x.
     *
     * <p>Running time: O(1) actual</p>
     *
     * @param y node to become child
     * @param x node to become parent
     */
    protected void link(FibonacciHeapNode<T> y, FibonacciHeapNode<T> x)
    {
        // remove y from root list of heap
        y.left.right = y.right;
        y.right.left = y.left;

        // make y a child of x
        y.parent = x;
        y.parent = x;


        if (x.child == null) {
            x.child = y;
            y.right = y;
            y.left = y;
        } else {
            y.left = x.child;
            y.right = x.child.right;
            x.child.right = y;
            y.right.left = y;
        }

        // increase degree[x]
        x.degree++;

        // set mark[y] false
        y.mark = false;
    }



    class FibonacciHeapNode<T>{
        //~ Instance fields --------------------------------------------------------

        /**
         * Node data.
         */
        T data;

        /**
         * first child node
         */
        FibonacciHeapNode<T> child;

        /**
         * left sibling node
         */
        FibonacciHeapNode<T> left;

        /**
         * parent node
         */
        FibonacciHeapNode<T> parent;

        /**
         * right sibling node
         */
        FibonacciHeapNode<T> right;

        /**
         * true if this node has had a child removed since this node was added to
         * its parent
         */
        boolean mark;

        /**
         * key value for this node
         */
        double key;

        /**
         * number of children of this node (does not count grandchildren)
         */
        int degree;

        //~ Constructors -----------------------------------------------------------

        /**
         * Default constructor. Initializes the right and left pointers, making this
         * a circular doubly-linked list.
         *
         * @param data data for this node
         * @param key initial key for node
         */
        public FibonacciHeapNode(T data, double key)
        {
            right = this;
            left = this;
            this.data = data;
            this.key = key;
        }

        //~ Methods ----------------------------------------------------------------

        /**
         * Obtain the key for this node.
         *
         * @return the key
         */
        public final double getKey()
        {
            return key;
        }

        /**
         * Obtain the data for this node.
         */
        public final T getData()
        {
            return data;
        }

        /**
         * Return the string representation of this object.
         *
         * @return string representing this object
         */
        public String toString()
        {
            if (true) {
                return Double.toString(key);
            } else {
                StringBuffer buf = new StringBuffer();
                buf.append("Node=[parent = ");

                if (parent != null) {
                    buf.append(Double.toString(parent.key));
                } else {
                    buf.append("---");
                }

                buf.append(", key = ");
                buf.append(Double.toString(key));
                buf.append(", degree = ");
                buf.append(Integer.toString(degree));
                buf.append(", right = ");

                if (right != null) {
                    buf.append(Double.toString(right.key));
                } else {
                    buf.append("---");
                }

                buf.append(", left = ");

                if (left != null) {
                    buf.append(Double.toString(left.key));
                } else {
                    buf.append("---");
                }

                buf.append(", child = ");

                if (child != null) {
                    buf.append(Double.toString(child.key));
                } else {
                    buf.append("---");
                }

                buf.append(']');

                return buf.toString();
            }
        }

        // toString
    }

}
