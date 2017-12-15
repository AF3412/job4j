package ru.af3412.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 15.12.2017.
 */
public class SimpleQueueTest {


    @Test
    public void whenAddOneElementToSimpleQueueSizeSimpleQueueIsOne() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);

        int result = simpleQueue.size();

        assertThat(result, is(1));
    }


    @Test
    public void whenAddOneElementToSimpleQueueAfterPollSizeIsNull() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.poll();

        int result = simpleQueue.size();

        assertThat(result, is(0));
    }


    @Test
    public void whenAddOneElementToSimpleQueuePollReturnThisElement() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);

        int result = simpleQueue.poll();

        assertThat(result, is(1));
    }


    @Test
    public void whenAddThreeElementToSimpleQueuePollReturnThisElement() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);

        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }


    @Test (expected = NoSuchElementException.class)
    public void whenSimpleQueueIsEmptyPollReturnNull() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();

        simpleQueue.poll();
    }

}