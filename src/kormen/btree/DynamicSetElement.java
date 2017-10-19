package kormen.btree;

/**
 * Created by Baka on 22.04.2016.
 */
public interface DynamicSetElement extends Comparable {

    /**
     * Sets the key of an element
     * @param key Key to be set
     */
    public void setKey(Comparable key);

    /**
     * Returns the key of an element
     * @return
     */
    public Comparable getKey();

    /**
     * Compares this <code>DynamicSetElement</code> to another object.
     * The normal implementation is simply <code>return
     * DynamicSetElement.Helper.compareTo(this, e);</code>
     *
     * @param e The other object.
     * @return A negative integer if this
     * <code>DynamicSetElement</code> is less; 0 if the objects are
     * equal; a positive integer if this
     * <code>DynamicSetElement</code> is greater
     * @throws java.lang.ClassCastException if the implementation calls
     * <code>DynamicSetElement.Helper.compareTo(this, e)</code> and
     * <code>e</code> does not implement <code>Comparable</code>
     */
    public int compareTo(Object e);

    /**
     * Inner class to define static helper methods
     */
    public static class Helper{
        public static int compareTo(DynamicSetElement e, Object o){
            if (o instanceof DynamicSetElement)
                return e.getKey().compareTo(((DynamicSetElement) o).getKey());
            else if (o instanceof Comparable)
                return e.getKey().compareTo(o);
            else
                throw new ClassCastException("Attempt to compare a DynamicSetElement");
        }

        public static DynamicSetElement cast(Object o){
            if (o instanceof DynamicSetElement)
                return (DynamicSetElement) o;
            else
                throw new ClassCastException("Object fails to implement DynamicSetElement interface");
        }
    }
}
