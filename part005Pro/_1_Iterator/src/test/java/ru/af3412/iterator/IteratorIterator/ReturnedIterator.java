package ru.af3412.iterator.IteratorIterator;

import java.util.Iterator;

/**
 * Created by AF on 27.06.2017.
 */
public class ReturnedIterator implements Iterator<Integer> {

    /**
     * Array values.
     */
    private final Integer[] values;

    /**
     * Index for array.
     */
    private int index = 0;

    public ReturnedIterator(Integer[] values) {
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
