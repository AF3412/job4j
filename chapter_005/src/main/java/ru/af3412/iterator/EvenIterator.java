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
        boolean result = false;
        for (int i = this.index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = true;
                this.index = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        int even = 0;
        int i = index;
        for (; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                even = values[i];
                break;
            }
        }
        index = ++i;

        return even;
    }

}
