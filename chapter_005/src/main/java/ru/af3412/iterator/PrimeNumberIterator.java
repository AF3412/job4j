package ru.af3412.iterator;

import java.util.Iterator;

/**
 * Created by Asus on 23.06.2017.
 */
public class PrimeNumberIterator implements Iterator {


    /**
     * Array values.
     */
    private final int[] values;

    /**
     * Index for array.
     */
    private int index = 0;

    /**
     * Instantiates a new Prime number iterator.
     *
     * @param values the values
     */
    public PrimeNumberIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = this.index; i < values.length; i++) {
            if (isPrime(values[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        int prime = 0;
        int i = index;
        for (; i < values.length; i++) {
            if (isPrime(values[i])) {
                prime = values[i];
                break;
            }
        }
        index = ++i;
        return prime;
    }

    /**
     * Check number is Prime or not.
     *
     * @param value is check number
     * @return boolean result prime number
     */
    private boolean isPrime(int value) {
        boolean result = false;
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return result;
            }
        }
        result = true;
        return result;
    }


}
