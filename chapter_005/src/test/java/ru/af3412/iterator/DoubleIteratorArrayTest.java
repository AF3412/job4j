package ru.af3412.iterator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Филатов on 26.05.2017.
 */
public class DoubleIteratorArrayTest {

    /**
     * When add one value method next return this value.
     */
    @Test
    public void whenAddOneValueMethodNextReturnThisValue() {
        int[][] value = {{0}, };
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        int checked = 0;

        int result = dia.next();

        assertThat(result, is(checked));
    }

    /**
     * When add four values in double array next return four values in sequence.
     */
    @Test
    public void whenAddFourValuesInDoubleArrayNextReturnFourValuesInSequence() {
        int[][] value = {{1, 2}, {3, 4}};
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        int[] checked = {1, 2, 3, 4};

        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            result[i] = dia.next();
        }

        assertThat(result, is(checked));
    }

    /**
     * When add two values in double array next return two values in sequence.
     */
    @Test
    public void whenAddTwoValuesInDoubleArrayNextReturnTwoValuesInSequence() {
        int[][] value = {{1}, {2}};
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        int[] checked = {1, 2};

        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            result[i] = dia.next();
        }

        assertThat(result, is(checked));
    }

    /**
     * When next value is exist has next return true.
     */
    @Test
    public void whenNextValueIsExistHasNextReturnTrue() {
        int[][] value = {{0}, {1}};
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        boolean checked = true;

        dia.next();
        boolean result = dia.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When next value is not exist has next return false.
     */
    @Test
    public void whenNextValueIsNotExistHasNextReturnFalse() {
        int[][] value = {{0}, {1}};
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        boolean checked = false;

        dia.next();
        dia.next();
        boolean result = dia.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When next value in array with defferent string is not exist has next return false.
     */
    @Test
    public void whenNextValueInArrayWithDifferentStringIsNotExistHasNextReturnFalse() {
        int[][] value = {{0}, {1, 2}, {1, 2, 3}};
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        boolean checked = false;

        dia.next();
        dia.next();
        dia.next();
        dia.next();
        dia.next();
        dia.next();
        boolean result = dia.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When next value in array with different string is exist has next return true.
     */
    @Test
    public void whenNextValueInArrayWithDifferentStringIsExistHasNextReturnTrue() {
        int[][] value = {{0}, {1, 2}, {1, 2, 3}};
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        boolean checked = true;

        dia.next();
        dia.next();
        dia.next();
        dia.next();
        dia.next();
        boolean result = dia.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When next value in array with two string and three and one columns is exist has next return true.
     */
    @Test
    public void whenNextValueInArrayWithTwoStringAndThreeAndOneColumnsIsExistHasNextReturnTrue() {
        int[][] value = {{0, 1, 2}, {1}};
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        boolean checked = true;

        dia.next();
        dia.next();
        dia.next();
        boolean result = dia.hasNext();

        assertThat(result, is(checked));
    }

    /**
     * When next value in array with two string and three and one columns is exist has next return false.
     */
    @Test
    public void whenNextValueInArrayWithTwoStringAndThreeAndOneColumnsIsExistHasNextReturnFalse() {
        int[][] value = {{0, 1, 2}, {1}};
        DoubleIteratorArray dia = new DoubleIteratorArray(value);
        boolean checked = false;

        dia.next();
        dia.next();
        dia.next();
        dia.next();
        boolean result = dia.hasNext();

        assertThat(result, is(checked));
    }


}