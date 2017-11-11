package ru.af3412.list;

import java.util.Iterator;

/**
 * Created by AF on 11.11.2017.
 *
 * @param <E> the type parameter
 */
public class DynamicListArray<E> implements Iterable<E> {

    /**
     * index is container index.
     */
    private int index = 0;

    /**
     * Container for object.
     */
    private Object[] container;

    /**
     * Instantiates a new Dynamic list array.
     */
    public DynamicListArray() {
        this(100);
    }

    /**
     * Instantiates a new Dynamic list array.
     *
     * @param size the size
     */
    public DynamicListArray(int size) {
        this.container = new Object[size];
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return this.index;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * Add boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean add(E value) {
        boolean result = false;
        if (checkContainerSize()) {
            this.container[index++] = value;
            result = true;
        } else {
            result = increaseContainerSize();
            this.container[index++] = value;
        }
        return result;
    }

    /**
     * Remove boolean.
     *
     * @param position the position
     * @return the boolean
     */
    public boolean remove(int position) {
        boolean result = false;
        if (checkBoundary(position)) {
            this.container[position] = null;
            indexingArray();
            result = true;
        }
        return result;
    }

    /**
     * Gets value.
     *
     * @param position the position
     * @return the value
     * @throws IndexOutOfBoundsException the index out of bounds exception
     */
    public E getValue(int position) throws IndexOutOfBoundsException {
        return (E) this.container[position];
    }

    /**
     * check position.
     *
     * @param position the position of container.
     * @return false if position out of range.
     */
    private boolean checkBoundary(int position) {
        return ((position >= 0) && (position < this.container.length));
    }

    /**
     * doubles container size.
     *
     * @return false if size of container out of MAX INTEGER SIZE.
     */
    private boolean increaseContainerSize() {
        boolean result = false;
        int containerSize = this.container.length;
        try {
            int newSize = Math.addExact(containerSize, containerSize);
            Object[] tmpContainer = new Object[newSize];
            System.arraycopy(this.container, 0, tmpContainer, 0, containerSize);
            this.container = tmpContainer;
            result = true;
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.printf("Error array size. Old container size: %s. New Container size: %s%n",
                    containerSize, containerSize * 2);
        }
        return result;
    }

    /**
     * Move null value in array to end.
     */
    private void indexingArray() {
        Object[] tmpContainer = new Object[this.container.length];
        int j = 0;
        for (int i = 0; i < tmpContainer.length; i++) {
            if (this.container[i] != null) {
                tmpContainer[j++] = this.container[i];
            }
        }
        this.container = tmpContainer;
    }

    /**
     * check size of container.
     *
     * @return false if index out of size of container.
     */
    private boolean checkContainerSize() {
        return ((index + 1) != this.container.length);
    }

    /**
     * private class for Iterator realisation.
     */
    private class Itr implements Iterator {
        /**
         * The Cursor.
         */
        private int cursor = 0;
        /**
         * The Check elements.
         */
        private int checkElements = index;
        /**
         * The Data.
         */
        private Object[] data = container;

        @Override
        public boolean hasNext() {
            return cursor != checkElements;
        }

        @Override
        public E next() {
            E result = (E) data[cursor];
            cursor++;
            return result;
        }
    }
}
