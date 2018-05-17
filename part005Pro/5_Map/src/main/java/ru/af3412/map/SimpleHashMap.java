package ru.af3412.map;

import java.util.Iterator;

/**
 * The type Simple hash map.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class SimpleHashMap<K, V> implements Iterable {

    /**
     * Object container.
     */
    private Object[] container;

    /**
     * count of object in container.
     */
    private int count = 0;

    /**
     * count for iterator.
     */
    private int iteratorCount = 0;

    /**
     * Instantiates a new Simple hash map.
     */
    public SimpleHashMap() {
        this(10);
    }

    /**
     * Instantiates a new Simple hash map.
     *
     * @param size the size
     */
    public SimpleHashMap(int size) {
        container = new Object[size];
    }

    /**
     * Insert boolean.
     *
     * @param key   the key
     * @param value the value
     * @return the boolean
     */
    boolean insert(K key, V value) {
        boolean result = false;
        int hash = getHash(key);
        if (container[hash] == null) {
            if (count >= container.length - 1) {
                increaseSize();
            }
            container[hash] = new Node(key, value);
            result = true;
            count++;
        }
        return result;
    }

    /**
     * Get v.
     *
     * @param key the key
     * @return the value
     */
    V get(K key) {
        Node result = (Node) container[getHash(key)];
        if (result == null) {
            return null;
        }
        return result.value;
    }

    /**
     * Delete boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean delete(K key) {
        boolean result = false;
        if (container[getHash(key)] != null) {
            container[getHash(key)] = null;
            result = true;
            count--;
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                int bound = container.length;
                for (int i = iteratorCount; i < bound; i++) {
                    if (container[i] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Node next() {
                int bound = container.length;
                for (int i = iteratorCount; i < bound; i++) {
                    if (container[i] != null) {
                        iteratorCount++;
                        return (Node) container[i];
                    }
                }
                return null;
            }
        };
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    int getSize() {
        return count;
    }

    /**
     * Calculating hash-code.
     *
     * @param key is key.
     * @return hash code
     */
    private int getHash(K key) {
        return Math.abs(key.hashCode() % container.length);
    }

    /**
     * Calculating hash-code with new container size.
     *
     * @param key  is key.
     * @param size is new container size.
     * @return hash code
     */
    private int getHash(K key, int size) {
        return Math.abs(key.hashCode() % size);
    }

    /**
     * Double size of container.
     */
    private void increaseSize() {
        int size = this.container.length * 2;
        Object[] tmpContainer = new Object[size];
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Node node = (Node) iterator.next();
            tmpContainer[getHash(node.key, size)] = node;
        }
        this.container = tmpContainer;
    }

    /**
     * Inner node.
     */
    private class Node {
        /**
         * The Key.
         */
        private K key;
        /**
         * The Value.
         */
        private V value;

        /**
         * Instantiates a new Node.
         *
         * @param key   the key
         * @param value the value
         */
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Gets key.
         *
         * @return the key
         */
        public K getKey() {
            return key;
        }

        /**
         * Sets key.
         *
         * @param key the key
         */
        public void setKey(K key) {
            this.key = key;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets value.
         *
         * @param value the value
         */
        public void setValue(V value) {
            this.value = value;
        }
    }

}