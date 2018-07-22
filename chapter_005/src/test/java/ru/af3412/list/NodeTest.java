package ru.af3412.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 19.12.2017.
 */
public class NodeTest {

    /**
     * When create list without cycle return false.
     */
    @Test
    public void whenCreateListWithoutCycleReturnFalse() {

        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = four;

        boolean result = first.hasCycle(first);

        assertThat(result, is(false));
    }

    /**
     * When create list with cycle return true.
     */
    @Test
    public void whenCreateListWithCycleReturnTrue() {

        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        boolean result = first.hasCycle(first);

        assertThat(result, is(true));
    }

    /**
     * When create list with cycle in middle return true.
     */
    @Test
    public void whenCreateListWithCycleInMiddleReturnTrue() {

        Node<Integer> first = new Node<>(4);
        Node<Integer> two = new Node<>(3);
        Node<Integer> third = new Node<>(2);
        Node<Integer> four = new Node<>(1);

        first.next = two;
        two.next = third;
        third.next = two;
        four.next = third;

        boolean result = first.hasCycle(first);

        assertThat(result, is(true));
    }

    /**
     * When create list with one node and next is null return false.
     */
    @Test
    public void whenCreateListWithOneNodeAndNextIsNullReturnFalse() {

        Node<Integer> first = new Node<>(4);

        boolean result = first.hasCycle(first);

        assertThat(result, is(false));
    }

    /**
     * When create list with one node and next is this node return true.
     */
    @Test
    public void whenCreateListWithOneNodeAndNextIsThisNodeReturnTrue() {

        Node<Integer> first = new Node<>(4);
        first.next = first;

        boolean result = first.hasCycle(first);

        assertThat(result, is(true));
    }

    /**
     * When create list with two node without cycle has cycle return false.
     */
    @Test
    public void whenCreateListWithTwoNodeWithoutCycleHasCycleReturnFalse() {

        Node<Integer> first = new Node<>(4);
        Node<Integer> two = new Node<>(2);
        first.next = two;

        boolean result = first.hasCycle(first);

        assertThat(result, is(false));
    }

    /**
     * When create list with two node with cycle has cycle return true.
     */
    @Test
    public void whenCreateListWithTwoNodeWithCycleHasCycleReturnTrue() {

        Node<Integer> first = new Node<>(4);
        Node<Integer> two = new Node<>(2);
        first.next = two;
        two.next = first;

        boolean result = first.hasCycle(first);

        assertThat(result, is(true));
    }

}