package ru.af3412.iterator;

import java.util.Iterator;

/**
 * Created by Филатов on 25.05.2017.
 */
public class DoubleIteratorArray<T> implements Iterator<T> {

    private final int[][] values;
    private int indexString = 0;
    private int indexColumn = 0;

    public DoubleIteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;



        return result;
    }

    @Override
    public T next() {



        return (T) values;

    }

    private void nextLine() {
        if (indexColumn >= values[indexString].length) {
            indexString++;
            indexColumn = 0;
        }
        else {
            indexColumn++;
        }
    }

}
