package ru.af3412.iterator.IteratorIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by AF on 28.06.2017.
 */
public class ReleaseIteratorIt implements IteratorIt {

    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        ArrayList<Integer> array = new ArrayList<>();
        while (it.hasNext()) {
            Iterator<Integer> value = it.next();
            while (value.hasNext()) {

                array.add(value.next());
            }
        }

        return array.iterator();
    }

}
