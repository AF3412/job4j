package ru.af3412.iterator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Asus on 24.06.2017.
 */
public class PrimeNumberIteratorTest {

    /**
     * When add one simple value method next return this value.
     */
    @Test
    public void whenAddOneSimpleValueMethodNextReturnThisValue() {
        int[] value = {3};
        PrimeNumberIterator pi = new PrimeNumberIterator(value);
        int checked = 3;

        int result = pi.next();

        assertThat(result, is(checked));
    }

    /**
     * When add few value with two simple value method next return only simple value.
     */
    @Test
    public void whenAddFewValueWithTwoSimpleValueMethodNextReturnOnlySimpleValue() {
        int[] value = {3, 4, 6, 5};
        PrimeNumberIterator pi = new PrimeNumberIterator(value);
        int[] checked = {3, 5};

        int[] result = new int[2];
        result[0] = pi.next();
        result[1] = pi.next();

        assertThat(result, is(checked));
    }

    /**
     * When next value is exist has next return true.
     */
    @Test
    public void whenNextValueIsExistHasNextReturnTrue() {
        int[] value = {4, 4, 3, 4};
        PrimeNumberIterator pi = new PrimeNumberIterator(value);
        boolean checked = true;

        boolean result = pi.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When two value is exist has next return true.
     */
    @Test
    public void whenTwoValueIsExistHasNextReturnTrue() {
        int[] value = {4, 4, 3, 4, 7, 8};
        PrimeNumberIterator pi = new PrimeNumberIterator(value);
        boolean checked = true;

        pi.next();
        boolean result = pi.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When two value is not exist has next return false.
     */
    @Test
    public void whenTwoValueIsNotExistHasNextReturnFalse() {
        int[] value = {4, 3, 4, 7, 8};
        PrimeNumberIterator pi = new PrimeNumberIterator(value);
        boolean checked = false;

        pi.next();
        pi.next();
        boolean result = pi.hasNext();

        assertThat(result, is(checked));
    }

}