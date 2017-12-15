package ru.af3412.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 15.12.2017.
 */
public class SimpleStackTest {

    /**
     * When add one element to simple stack size simple stack is one.
     */
    @Test
    public void whenAddOneElementToSimpleStackSizeSimpleStackIsOne() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);

        int result = simpleStack.size();

        assertThat(result, is(1));
    }

    /**
     * When add one element to simple stack after poll size is null.
     */
    @Test
    public void whenAddOneElementToSimpleStackAfterPollSizeIsNull() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.poll();

        int result = simpleStack.size();

        assertThat(result, is(0));
    }

    /**
     * When add one element to simple stack poll return this element.
     */
    @Test
    public void whenAddOneElementToSimpleStackPollReturnThisElement() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);

        int result = simpleStack.poll();

        assertThat(result, is(1));
    }

    /**
     * When add three element to simple stack poll return this element.
     */
    @Test
    public void whenAddThreeElementToSimpleStackPollReturnThisElement() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);

        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }

    /**
     * When simple stack is empty poll return null.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenSimpleStackIsEmptyPollReturnNull() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();

        simpleStack.poll();
    }

}