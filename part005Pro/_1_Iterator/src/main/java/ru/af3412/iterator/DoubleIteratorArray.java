package ru.af3412.iterator;

import java.util.Iterator;

/**
 * Created by Филатов on 25.05.2017.
 */
public class DoubleIteratorArray implements Iterator {

    /**
     * Double arrays values.
     */
    private final int[][] values;
    /**
     * Index for rows in array.
     */
    private int indexString = 0;
    /**
     * Index for columns in array.
     */
    private int indexColumn = 0;

    /**
     * Instantiates a new Double iterator array.
     *
     * @param values the values
     */
    public DoubleIteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return (indexString < values.length);
    }

    @Override
    public Integer next() {
        int val = values[indexString][indexColumn];

        if (indexColumn == values[indexString].length - 1) {
            indexString++;
            indexColumn = 0;
        } else {
            indexColumn++;
        }

        return val;
    }

}
