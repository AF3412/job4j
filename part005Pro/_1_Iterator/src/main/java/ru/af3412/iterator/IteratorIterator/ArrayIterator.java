package ru.af3412.iterator.IteratorIterator;

import java.util.Iterator;

/**
 * Created by AF on 27.06.2017.
 */
public class ArrayIterator implements Iterator {

    /**
     * Array values.
     */
    private final int[] values;

    /**
     * Index for array.
     */
    private int index = 0;

    /**
     * Instantiates a new Array iterator.
     *
     * @param values the values
     */
    public ArrayIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return (index + 1 <= values.length);
    }

    @Override
    public Integer next() {
        return values[index++];
    }
}
