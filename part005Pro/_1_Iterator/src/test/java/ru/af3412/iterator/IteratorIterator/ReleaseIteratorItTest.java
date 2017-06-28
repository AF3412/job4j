package ru.af3412.iterator.IteratorIterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by AF on 28.06.2017.
 */
public class ReleaseIteratorItTest {

    /**
     * When add three inners iterators return integer iterator.
     */
    @Test
    public void whenAddThreeInnersIteratorsReturnIntegerIterator() {

        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(4, 2));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(0, 9, 3));
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(1, 3));
        Iterator<Integer> iterator1 = array1.iterator();
        Iterator<Integer> iterator2 = array2.iterator();
        Iterator<Integer> iterator3 = array3.iterator();
        ArrayList<Iterator<Integer>> ai = new ArrayList<>(Arrays.asList(iterator1, iterator2, iterator3));
        Iterator<Iterator<Integer>> itInteger = ai.iterator();
        ArrayList<Integer> checked = new ArrayList<>(Arrays.asList(4, 2, 0, 9, 3, 1, 3));

        ReleaseIteratorIt ri = new ReleaseIteratorIt();
        Iterator<Integer> resultIterator = ri.convert(itInteger);
        ArrayList<Integer> result = new ArrayList<>();
        while (resultIterator.hasNext()) {
            result.add(resultIterator.next());
        }

        assertThat(result, is(checked));

    }

}