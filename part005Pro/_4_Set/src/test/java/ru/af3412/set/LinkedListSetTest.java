package ru.af3412.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 06.02.2018.
 */
public class LinkedListSetTest {

    /**
     * When add one value to set get size method return one.
     */
    @Test
    public void whenAddOneValueToSetGetSizeMethodReturnOne() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(0);
        int result = set.getSize();

        assertThat(result, is(1));
    }

    /**
     * When add two different value to list get size method return two.
     */
    @Test
    public void whenAddTwoDifferentValueToListGetSizeMethodReturnTwo() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
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
        LinkedListSet<Integer> set = new LinkedListSet<>();
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
        LinkedListSet<Integer> set = new LinkedListSet<>();
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

    /**
     * When add duplicate values returned only unique values.
     */
    @Test
    public void whenAddDuplicateValuesReturnedOnlyUniqueValues() {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);
        set.add(1);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> result = new ArrayList<>();
        for (Integer i : set) {
            result.add(i);
        }
        assertThat(result, is(expected));
    }

}