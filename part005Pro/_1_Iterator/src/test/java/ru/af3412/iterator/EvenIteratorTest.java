package ru.af3412.iterator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Филатов on 27.05.2017.
 */
public class EvenIteratorTest {

    /**
     * When add zero value method next return this value.
     */
    @Test
    public void whenAddZeroValueMethodNextReturnThisValue() {
        int[] value = {0};
        EvenIterator ei = new EvenIterator(value);
        int checked = 0;

        int result = ei.next();

        assertThat(result, is(checked));
    }

    /**
     * When add few value method next return even value.
     */
    @Test
    public void whenAddFewValueMethodNextReturnEvenValue() {
        int[] value = {2, 4, 6, 1};
        EvenIterator ei = new EvenIterator(value);
        int[] checked = {2, 4, 6};
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            result[i] = ei.next();
        }

        assertThat(result, is(checked));
    }

    /**
     * When add few difference value method next return even value.
     */
    @Test
    public void whenAddFewDifferenceValueMethodNextReturnEvenValue() {
        int[] value = {2, 4, 6, 1, 8, 5, 6};
        EvenIterator ei = new EvenIterator(value);
        int[] checked = {2, 4, 6, 8, 6};
        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            result[i] = ei.next();
        }

        assertThat(result, is(checked));
    }

    /**
     * When next value is exist has next return true.
     */
    @Test
    public void whenNextValueIsExistHasNextReturnTrue() {
        int[] value = {1, 2, 3};
        EvenIterator ei = new EvenIterator(value);
        boolean checked = true;

        ei.next();
        boolean result = ei.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When next value is exist has next return false.
     */
    @Test
    public void whenNextValueIsNotExistHasNextReturnFalse() {
        int[] value = {1};
        EvenIterator ei = new EvenIterator(value);
        boolean checked = false;

        ei.next();
        boolean result = ei.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When next value is not exist and previous is even has next return false.
     */
    @Test
    public void whenNextValueIsNotExistAndPreviousIsEvenHasNextReturnFalse() {
        int[] value = {2};
        EvenIterator ei = new EvenIterator(value);
        boolean checked = false;

        ei.next();
        boolean result = ei.hasNext();

        assertThat(result, is(checked));
    }

}