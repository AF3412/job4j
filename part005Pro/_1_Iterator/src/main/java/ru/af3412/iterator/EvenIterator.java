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
     * Array with even values.
     */
    private int[] evenValues;

    /**
     * Check is init added even values to array evenValues.
     */
    private boolean init;

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
        return index < evenValues.length;
    }

    @Override
    public Integer next() {
        int even;
        if (!init) {
            evenValues = evenValue();
            init = true;
        }
        even = evenValues[index++];

        return even;
    }

    /**
     * This method added even values from initial array to even values array.
     * @return array with even values.
     */
    private int[] evenValue() {
        int[] evenValues = new int[this.values.length];
        int evenIndex = 0;

        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {
                evenValues[evenIndex++] = this.values[i];
            }
        }

        return evenValues;

    }

}
