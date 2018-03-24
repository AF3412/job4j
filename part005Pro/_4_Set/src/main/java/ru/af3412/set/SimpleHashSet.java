package ru.af3412.set;


import java.util.Arrays;

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
        if (!contains(value)) {
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
    public boolean contains(E value) {
        boolean result = true;
        if ((container[createHashValue(value)]) == null) {
            result = false;
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

        for (InnerObjectClass ioc : oldContainer) {
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
        int hash = 0;
        if (e.getClass().getName().equals("java.lang.String")) {
            char[] charArray = ((String) e).toCharArray();
            for (char aCharArray : charArray) {
                hash = 31 * hash + aCharArray;
            }
            hash = hash % containerSize;
        } else if (e.getClass().getName().equals("java.lang.Integer")) {
            int value = (Integer) e;
            hash = (value < 200) ? value : value % containerSize;
        } else {
            hash = e.hashCode() > 0 ? e.hashCode() : e.hashCode() * (-1);
            hash = hash % containerSize;
        }

        return hash;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleHashSet)) return false;
        SimpleHashSet<?> that = (SimpleHashSet<?>) o;
        return Arrays.equals(container, that.container);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(container);
    }
}
