package ru.af3412.iterator.IteratorIterator;

import java.util.Iterator;

/**
 * Created by AF on 27.06.2017.
 */
public interface IteratorIt {

    /**
     * Convert iterator.
     *
     * @param it the it
     * @return the iterator
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);

}
