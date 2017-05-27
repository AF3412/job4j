package ru.af3412.iterator;

import java.util.Iterator;

/**
 * Created by Филатов on 27.05.2017.
 */
public class EvenIterator implements Iterator {

    /**
     * Array values.
     */
    private final int[] values;

    /**
     * Index for array.
     */
    private int index = 0;

    /**
     * Instantiates a new Even iterator.
     *
     * @param values the values
     */
    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public Integer next() {
        int val;
        if (values[index] % 2 == 0) {
            val = values[index];
        } else {
            val = -1;
        }
        index++;
        return val;
    }

}
