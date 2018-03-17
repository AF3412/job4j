package ru.af3412.set;


/**
 * Created by AF on 03.03.2018.
 *
 * @param <E> the type parameter
 */
public class SimpleHashSet<E> {

    private InnerObjectClass[] container;

    private int containerSize = 0;
    private int size = 0;

    /**
     * Instantiates a new Simple hash set.
     */
    public SimpleHashSet() {
        this(100);
    }

    /**
     * Instantiates a new Simple hash set.
     *
     * @param containerSize the container size
     */
    public SimpleHashSet(int containerSize) {
        this.containerSize = containerSize;
        this.container = new InnerObjectClass[containerSize];
    }

    /**
     * Add boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean add(E value) {
        boolean result = false;
        if (size == containerSize) {
            this.container = increaseContainer(this.container);
        }
        if (!contains(value) ) {
            container[createHashValue(value)] = new InnerObjectClass(value);
            result = true;
            size++;
        }

        return result;
    }

    /**
     * Contains boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean contains (E value) {
        boolean result = false;
        for(InnerObjectClass ioc : container) {
            if (ioc != null) {
                if (createHashValue(value) == ioc.getHashValueKey()) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Remove boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean remove(E value) {
        boolean result = false;
        if (contains(value)) {
            this.container[createHashValue(value)] = null;
            size--;
            result = true;
        }
        return result;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return this.size;
    }

    private InnerObjectClass[] increaseContainer(InnerObjectClass[] oldContainer) {
        this.size = this.size * 2;
        InnerObjectClass[] newContainer = new InnerObjectClass[this.size];

        for(InnerObjectClass ioc : oldContainer) {
            newContainer[createHashValue(ioc.getValue())] = new InnerObjectClass(ioc.getValue());
        }
        return newContainer;
    }

    private class InnerObjectClass<E> {

        private E o;
        private int hashValueKey;

        /**
         * Instantiates a new Inner object class.
         *
         * @param o the o
         */
        public InnerObjectClass(E o) {
            hashValueKey = createHashValue(o);
            this.o = o;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public E getValue() {
            return o;
        }

        /**
         * Gets hash value key.
         *
         * @return the hash value key
         */
        public int getHashValueKey() {
            return hashValueKey;
        }

    }

    private int createHashValue(Object e) {
        return e.hashCode() % containerSize;
    }

}
