package ru.af3412.iterator.iteratoriterator;

import java.util.Iterator;

/**
 * Created by AF on 28.06.2017.
 */
public class ReleaseIteratorIt implements Iterator<Integer> {


    /**
     * external iterator.
     */
    private Iterator<Iterator<Integer>> exIterator;

    /**
     * inner iterator.
     */
    private Iterator<Integer> inIterator;

    /**
     * @param it is object Iterator<Iterator<Integer>>
     * @return Iterator<Integer>. is number(int) iterator
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.exIterator = it;
        if (exIterator.hasNext()) {
            this.inIterator = it.next();
        }
        return this;
    }


    @Override
    public boolean hasNext() {
        return exIterator.hasNext() || inIterator.hasNext();
    }

    @Override
    public Integer next() {
        Integer result;
        if (inIterator.hasNext()) {
            result = inIterator.next();
        } else {
            inIterator = exIterator.next();
            result = inIterator.next();
        }
        return result;
    }
}
