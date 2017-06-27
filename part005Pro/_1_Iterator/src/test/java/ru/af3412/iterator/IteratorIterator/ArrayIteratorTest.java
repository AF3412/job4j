package ru.af3412.iterator.IteratorIterator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 27.06.2017.
 */
public class ArrayIteratorTest {

    /**
     * When add zero value method next return this value.
     */
    @Test
    public void whenAddZeroValueMethodNextReturnThisValue() {
        int[] value = {0};
        ArrayIterator ei = new ArrayIterator(value);
        int checked = 0;

        int result = ei.next();

        assertThat(result, is(checked));
    }

    /**
     * When add several value method next return this value.
     */
    @Test
    public void whenAddSeveralValueMethodNextReturnThisValue() {
        int[] value = {0, 1};
        ArrayIterator ei = new ArrayIterator(value);
        ei.next();
        int checked = 1;

        int result = ei.next();

        assertThat(result, is(checked));
    }

    /**
     * When exist next value method has next return true.
     */
    @Test
    public void whenExistNextValueMethodHasNextReturnTrue() {
        int[] value = {0, 1};
        ArrayIterator ei = new ArrayIterator(value);
        ei.next();
        boolean checked = true;

        boolean result = ei.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When exist next value method has next return false.
     */
    @Test
    public void whenExistNextValueMethodHasNextReturnFalse() {
        int[] value = {0, 1};
        ArrayIterator ei = new ArrayIterator(value);
        ei.next();
        ei.next();
        boolean checked = false;

        boolean result = ei.hasNext();

        assertThat(result, is(checked));
    }

}