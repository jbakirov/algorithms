package kormen.btree;

/**
 * Created by Baka on 21.04.2016.
 */
public class BTree <Key extends Comparable<Key>, Value> {

    /**
     * The root of the B-tree
     */
    private Node root;

    /**
     * The maximum degree, i.e. the minimum number of keys in any node other than the root
     */
    private final int t;

    /**
     *  The maximum number of keys in any node = 2*t - 1
     */
    private final int maxKeys;

    /**
     * Private inner class for a B-tree node
     */
    private class Node{
        /**
         * The number of keys stored in the node
         */
        private int n;

        /**
         * Array of the keys stored in the node
         */
        public DynamicSetElement[] key;

        /**
         * Pointers to the children, if this node is not a leaf. If
         * this node is a leaf, then <code>null</code>
         */
        public Node[] c;

        /**
         * <code>true</code> if this node is a leaf,
         * <code>false</code> if this node is an interior node
         */
        private boolean leaf;

        public Node(int n, boolean leaf){
            this.n = n;
            this.leaf = leaf;
            key = new DynamicSetElement[maxKeys];
            if (leaf)
                c = null;
            else
                c = (Node[]) new Object [maxKeys + 1];
        }

        private Node(int k){
            n = k;
        }


        public BTreeHandle BTreeSearch(Comparable k){
            int i = 0;
            while (i < n && key[i].compareTo(k) < 0)
                i++;

            if (i < n && key[i].compareTo(k) == 0)
                return new BTreeHandle(this, i);  // found it

            if (leaf)
                return null;
            else
                return c[i].BTreeSearch(k);
        }

        public void BTreeSplitChild (Node x, int i){
            Node z = new Node (t-1, leaf);

            //Copy the t-1 keys in positions t to 2t-2 into z
            for (int j = 0; j < t-1; j++){
                z.key[j] = key[j+t];
                key[j+t] = null; // remove the reference
            }

            if (!leaf){
                for (int j = 0; j < t; j++){
                    z.c[j] = c[j+t];
                    c[j+t] = null; // remove the reference
                }
            }
            n = t - 1;

            // Move the children in x that are to to the right of y by
            // one position to the right
            for (int j = x.n; j >= i + 1; j--)
                x.c[j+1] = x.c[j];

            // Drop z into x's child i+1
            x.c[i+1] = z;

            // Move the keys in x that are to the right of y by one
            // position to the right
            for (int j = x.n - 1; j >= i; j--)
                x.key[j+1] = x.key[j];

            // Move this node's median key into x, and remove the
            // reference to the key in this node

            x.key[i] = key[t - 1];
            key[t-1] = null;

            x.n++; // one more key/child in x
        }


        /**
         * Inserts a new element in this node, which is  assumed to be nonfull
         */
        public BTreeHandle BTreeInsertNonFull(DynamicSetElement k){
            int i = n - 1;
            Comparable kKey = k.getKey();

            if (leaf){
                //Move all keys greater than k's by one position to the right
                while (i >= 0 && key[i].compareTo(kKey) > 0){
                    key[i+1] = key[i];
                    i--;
                }

                // Either i is -1 or key[i] is the rightmost key <=
                // k's key.  In either case, drop k into position i+1.
                key[i+1] = k;
                n++;

                // Return the handle saying where we dropped k.
                return new BTreeHandle(this, i+1);
            }
            else {
                // Find which child we descend into.
                while (i >= 0 && key[i].compareTo(kKey) > 0)
                    i--;

                // Either i is -1 or key[i] is the rightmost key <=
                // k's key.  In either case, descend into position
                // i+1.
                i++;
                if (c[i].n == maxKeys) {
                    // That child is full, so split it, and possibly
                    // update i to descend into the new child.
                    c[i].BTreeSplitChild(this, i);
                    if (key[i].compareTo(kKey) < 0)
                        i++;
                }

                return c[i].BTreeInsertNonFull(k);
            }
        }

        /**
         * Inserts an element
         * @param o The element to insert
         * @return A handle to the new element
         * @throws java.lang.ClassCastException if <code>o</code> does not reference
         * a {@link kormen.btree.DynamicSetElement}.
         */
        public Object insert(Comparable o){
            Node r = root;
            DynamicSetElement e = DynamicSetElement.Helper.cast(o);

            if (r.n == maxKeys){
                //split the root
                Node s = new Node(0, false);
                root = s;
                s.c[0] = r;
                r.BTreeSplitChild(s, 0);
                return s.BTreeInsertNonFull(e);
            }else {
                return r.BTreeInsertNonFull(e);
            }
        }

        /**
         * Deletes an element with a given key from the subtree rooted at this node
         * @param k
         */
        public void delete (Comparable k){
            if (leaf)
                deleteFromLeaf(k);
            else{
                //determine if key is found int his node
                int i = 0;

                while (i < n && key[i].compareTo(k) < 0)
                    i++;

                if (i < n && key[i].compareTo(k) == 0)
                    deleteFromInternalNode(i); //found it, so delete it
                else{
                    // if it's in the subtree rooted at this node
                    // it's in the subtree rooted in child i
                    Node child = c[i];
                    ensureFullEnough(i); //ensure the child has  >= t keys
                }
            }
        }


        /**
         * Deletes an element with a given key from this node, which
         * is assumed to be a leaf ad already in memory. Does
         * nothing if this node does not contain an element with the
         * given key
         *
         * @param k The key of the element to be deleted
         */

        private void deleteFromLeaf(Comparable k){
            //Determine if k is found in this node
            int i=0;

            while (i < n && key[i].compareTo(k) < 0)
                i++;
            if (i < n && key[i].compareTo(k) == 0){
                //it's here and in position i. Move all keys in
                //positions greater than i by one position to the left

                for (int j = i + 1; j < n; j++)
                    key[j-1] = key[j];
                key[n-1] = null; //remove the reference
                n--;             // one fewer key

            }
        }


        /**
         * Deletes a given key from this node, which is assumed to be
         * an internal node and already in memory
         *
         *  @param i <code>key[i]</code> is deleted from this node
         */

        private void deleteFromInternalNode(int i){
            DynamicSetElement k = key[i]; // key i
            Node y = c[i];                // child preceding k

            if (y.n >= t){                // does y have at least t keys
                // if so, find the predecessor kPrime of k within the
                // subtree rooted at y. We find kPrime by starting at
                // y and always taking the rightmost child, until we
                // get to a leaf; kPrime is the element with the
                // greatest key in that leaf. Recursively delete
                // kPrime, and replace k by kPrime in this node.

                // Note: Although page 451 says that finding kPrime and
                // deleting it can be performed in a single downward
                // pass, for simplicity, we make separate passes to
                // find and delete it.

                DynamicSetElement kPrime = y.findGreatestInSubtree();
                y.delete(kPrime.getKey());
                key[i] = kPrime;
            } else {
                // Do the same for the child z that follows key i,
                // where kPrime is k's successor. Use the same
                // simplification as above

                Node z = c[i+1];

                if (z.n >= t){
                    DynamicSetElement kPrime = z.findSmallestInSubtree();
                    z.delete(kPrime.getKey());
                    key[i] = kPrime;
                } else {
                    // Both y and z have t-1 keys. Merge k and all of
                    // z into y. This node loses both k and the
                    // pointer to z, and y then contains 2t-1 keys.
                    // Then recursively delete k from y. Since this
                    // node, y, and z are the three most recently read
                    // nodes, we assume that they are in memory.

                    y.key[y.n] = k;
                    for (int j = 0; j < z.n; j++){
                        y.key[y.n + j + 1] = z.key[j];
                    }

                    // If y and z are not leaves, copy z's child
                    // pointers

                    if (!y.leaf){
                        for (int j = 0; j <= z.n; j++){
                            y.key[y.n + j + 1] = z.key[j];
                        }
                    }
                    y.n += z.n + 1;

                    //Remove k and z from this node
                    for (int j = i + 1; j < n; j++){
                        key[j-1] = key[j];
                        c[j] = c[j+1];
                    }
                    key[n-1] = null;
                    c[n] = null;
                    n--;

                    y.delete(k.getKey());
                }
            }
        }

        /**
         * Finds the dynamic set element with the greatest key in the subtree
         * rooted at this node. Works by always taking the rightmost child
         * until we get to leaf. Assumes that this node is already in memory
         *
         * @return The dynamic set element with the greates key in
         * the subtree rooted at this node.
         *
         */

        private DynamicSetElement findGreatestInSubtree(){
            if (leaf)
                return key[n-1];
            else {
                return c[n].findGreatestInSubtree();
            }
        }

        /**
         * Finds the dynamic set element with the smallest key in the
         * subtree rooted at this node. Works by always taking the
         * leftmost child until we get to a leaf. Assumes that this node
         * is already in memory.
         *
         * @return The dynamic set element with the smallest jey in
         * the subtree rooted at this node.
         */
        private DynamicSetElement findSmallestInSubtree(){
            if (leaf)
                return key[0];
            else
                return c[0].findSmallestInSubtree();

        }

        /**
         * Ensures that a given child of this node child has at least
         * <code>t</code> keys.  Assumes that this node and the child
         * are already in memory.
         *
         * @param i The <code>i</code>th child of this node is the one
         * that will have at last <code>t</code> keys.
         */
        private void ensureFullEnough(int i)
        {
            Node child = c[i];
            if (child.n < t) {
                Node leftSibling; // child's left sibling
                int leftN;	  // left sibling's n value

                if (i > 0) {
                    leftSibling = c[i-1];
                    leftN = leftSibling.n;
                }
                else {
                    leftSibling = null;
                    leftN = 0;
                }

                if (leftN >= t) { // does left sibling have at least t keys?
                    // Move all the child's keys (and its child
                    // pointers) to the right by one position.
                    for (int j = child.n-1; j >= 0; j--)
                        child.key[j+1] = child.key[j];
                    if (!child.leaf)
                        for (int j = child.n; j >= 0; j--)
                            child.c[j+1] = child.c[j];

                    // Move a key down from this node into child and
                    // from the left sibling into this node.
                    child.key[0] = key[i-1];
                    key[i-1] = leftSibling.key[leftN-1];
                    leftSibling.key[leftN-1] = null;

                    // If not leaves, move a pointer from the left
                    // sibling into child.
                    if (!child.leaf) {
                        child.c[0] = leftSibling.c[leftN];
                        leftSibling.c[leftN] = null;
                    }

                    leftSibling.n--; // one fewer key in left sibling
                    child.n++;	     // and one more in child

                    // 3 nodes changed.
                }
                else {		// do the symmetric thing with right sibling
                    Node rightSibling; // child's right sibling
                    int rightN;	       // right sibling's n value

                    if (i < n) {
                        rightSibling = c[i+1];
                        rightN = rightSibling.n;
                    }
                    else {
                        rightSibling = null;
                        rightN = 0;
                    }

                    if (rightN >= t) {
                        // Move a key down from this node into child
                        // and from the right sibling into this node.
                        child.key[child.n] = key[i];
                        key[i] = rightSibling.key[0];

                        // If not leaves, move a pointer from the
                        // right sibling into child.
                        if (!child.leaf)
                            child.c[child.n] = rightSibling.c[0];

                        // Move all the right sibling's keys (and its child
                        // pointers) to the left by one position.
                        for (int j = 1; j < rightN; j++)
                            rightSibling.key[j-1] = rightSibling.key[j];
                        rightSibling.key[rightN-1] = null;
                        if (!rightSibling.leaf) {
                            for (int j = 1; j <= rightN; j++)
                                rightSibling.c[j-1] = rightSibling.c[j];
                            rightSibling.c[rightN] = null;
                        }

                        rightSibling.n--; // one fewer key in right sibling
                        child.n++;	     // and one more in child

                        // 3 nodes changed.
                    }
                    else {
                        // The child and both of its siblings have t-1
                        // keys.  Merge one of the siblings into the
                        // child, moving a key from this node down
                        // into the child.
                        if (leftN > 0) {
                            // Merge the left sibling into the child.
                            // Start by moving everything in the child
                            // right by t positions.
                            for (int j = child.n-1; j >= 0; j--)
                                child.key[j+t] = child.key[j];
                            if (!child.leaf)
                                for (int j = child.n; j >= 0; j--)
                                    child.c[j+t] = child.c[j];

                            // Take everything from the left sibling.
                            for (int j = 0; j < leftN; j++) {
                                child.key[j] = leftSibling.key[j];
                                leftSibling.key[j] = null;
                            }
                            if (!child.leaf)
                                for (int j = 0; j <= leftN; j++) {
                                    child.c[j] = leftSibling.c[j];
                                    leftSibling.c[j] = null;
                                }

                            // Move a key down from this node into the child.
                            child.key[t-1] = key[i-1];

                            child.n += leftN + 1;

                            // Since this node is losing key i-1 and
                            // child pointer i-1, move keys i to n-1
                            // and children i to n left by one
                            // position in this node.
                            for (int j = i; j < n; j++) {
                                key[j-1] = key[j];
                                c[j-1] = c[j];
                            }
                            c[n-1] = c[n];
                            key[n-1] = null;
                            c[n] = null;
                            n--;

                        }
                        else {
                            // Merge the right sibling into the child.
                            // Start by taking everything from the
                            // right sibling.
                            for (int j = 0; j < rightN; j++) {
                                child.key[j+child.n+1] = rightSibling.key[j];
                                rightSibling.key[j] = null;
                            }
                            if (!child.leaf)
                                for (int j = 0; j <= rightN; j++) {
                                    child.c[j+child.n+1] = rightSibling.c[j];
                                    rightSibling.c[j] = null;
                                }

                            // Move a key down from this node into the child.
                            child.key[t-1] = key[i];

                            child.n += rightN + 1;

                            // Since this node is losing key i and
                            // child pointer i, move keys i+1 to n-1
                            // and children i+2 to n left by one
                            // position in this node.
                            for (int j = i+1; j < n; j++) {
                                key[j-1] = key[j];
                                c[j] = c[j+1];
                            }
                            key[n-1] = null;
                            c[n] = null;
                            n--;
                        }
                    }
                }
            }
        }

    }

    private class BTreeHandle {
        /**
         * A node in the B-tree
         */
        Node node;

        /**
         * Index of the key in the node
         */
        int i;

        public BTreeHandle(Node node, int i){
            this.node = node;
            this.i = i;
        }
    }

    public BTree(int t){
        this.t = t;
        maxKeys = 2 * t - 1;
        root = new Node(0, true);
    }


}
