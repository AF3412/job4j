package ru.af3412.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 29.12.2017.
 */
public class SimpleSetTest {


    /**
     * When add one value to set get size method return one.
     */
    @Test
    public void whenAddOneValueToSetGetSizeMethodReturnOne() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(0);
        int result = set.getSize();

        assertThat(result, is(1));
    }

    /**
     * When add two different value to list get size method return two.
     */
    @Test
    public void whenAddTwoDifferentValueToListGetSizeMethodReturnTwo() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(0);
        set.add(1);
        int result = set.getSize();

        assertThat(result, is(2));
    }

    /**
     * When add two same value to list get size method return one.
     */
    @Test
    public void whenAddTwoSameValueToListGetSizeMethodReturnOne() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(0);
        set.add(0);
        int result = set.getSize();

        assertThat(result, is(1));
    }

    /**
     * When get iterator returned list iterator.
     */
    @Test
    public void whenGetIteratorReturnedListIterator() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        Integer[] array = new Integer[]{1, 2, 3};
        ArrayList<Integer> tmpArray = new ArrayList<>(Arrays.asList(array));

        Iterator checked = tmpArray.iterator();
        Iterator result = set.iterator();

        while (checked.hasNext()) {
            assertThat(result.next(), is(checked.next()));
        }

    }

}