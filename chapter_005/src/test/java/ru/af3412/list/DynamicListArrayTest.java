package ru.af3412.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 11.11.2017.
 */
public class DynamicListArrayTest {

    /**
     * Base list for tests.
     */
    private DynamicListArray<Integer> list;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.list = new DynamicListArray<>();
    }

    /**
     * When add one value to list get size method return one.
     */
    @Test
    public void whenAddOneValueToListGetSizeMethodReturnOne() {
        this.list.add(0);
        int result = this.list.getSize();

        assertThat(result, is(1));
    }

    /**
     * When in list array is maximum size then array size is double.
     */
    @Test
    public void whenInListArrayIsMaximumSizeThenArraySizeIsDouble() {
        DynamicListArray<Integer> list = new DynamicListArray<>(1);
        list.add(0);
        list.add(0);

        int result = list.getSize();

        assertThat(result, is(2));
    }

    /**
     * When get value from list returned that value.
     */
    @Test
    public void whenGetValueFromListReturnedThatValue() {
        this.list.add(0);
        this.list.add(10);

        int result = list.getValue(1);

        assertThat(result, is(10));
    }

    /**
     * When get value from outside list throw exception.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetValueFromOutsideListThrowException() {
        list.getValue(-1);
    }

    /**
     * When get iterator returned list iterator.
     */
    @Test
    public void whenGetIteratorReturnedListIterator() {
        DynamicListArray<Integer> list = new DynamicListArray<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] array = new Integer[]{1, 2, 3};
        ArrayList<Integer> tmpArray = new ArrayList<>(Arrays.asList(array));

        Iterator checked = tmpArray.iterator();
        Iterator result = list.iterator();

        while (checked.hasNext()) {
            assertThat(result.next(), is(checked.next()));
        }

    }

    /**
     * When remove element in list array reindexed that no null in middle.
     */
    @Test
    public void whenRemoveElementInListArrayReindexedThatNoNullInMiddle() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        this.list.remove(1);
        int result = this.list.getValue(1);

        assertThat(result, is(3));
    }

}