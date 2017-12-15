package ru.af3412.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 19.11.2017.
 */
public class LinkedListContainerTest {


    /**
     * When add one value to list size list is one.
     */
    @Test
    public void whenAddOneValueToListSizeListIsOne() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();
        listContainer.add(1);

        int result = listContainer.getSize();

        assertThat(result, is(1));
    }

    /**
     * When add one value to list return this value.
     */
    @Test
    public void whenAddOneValueToListReturnThisValue() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();
        listContainer.add(1);

        int result = listContainer.get(0);

        assertThat(result, is(1));
    }

    /**
     * When add two value to list method return second value.
     */
    @Test
    public void whenAddTwoValueToListMethodReturnSecondValue() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();
        listContainer.add(1);
        listContainer.add(2);

        int result = listContainer.get(1);

        assertThat(result, is(2));
    }

    /**
     * When add value to list between two elements method return this element.
     */
    @Test
    public void whenAddValueToListBetweenTwoElementsMethodReturnThisElement() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();
        listContainer.add(1);
        listContainer.add(2);
        listContainer.add(0, 0);

        int result0 = listContainer.get(0);
        int result1 = listContainer.get(1);
        int result2 = listContainer.get(2);

        assertThat(result0, is(0));
        assertThat(result1, is(1));
        assertThat(result2, is(2));
    }

    /**
     * When get element from out of index then throw exception.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetElementFromOutOfIndexThenThrowException() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();
        listContainer.get(1);
    }

    /**
     * When delete element then list remove this element.
     */
    @Test
    public void whenDeleteElementByIndexThenListRemoveThisElement() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();
        listContainer.add(1);
        listContainer.add(2);

        listContainer.remove(0);

        int result = listContainer.get(0);

        assertThat(result, is(2));
    }

    /**
     * When delete element by value then list remove this element.
     */
    @Test
    public void whenDeleteElementByValueThenListRemoveThisElement() {
        LinkedListContainer<String> listContainer = new LinkedListContainer<>();
        listContainer.add("1");
        listContainer.add("2");

        listContainer.remove("1");

        String result = listContainer.get(0);

        assertThat(result, is("2"));
    }

    /**
     * When create list then iterator method worked.
     */
    @Test
    public void whenCreateListThenIteratorMethodWorked() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();
        listContainer.add(1);
        listContainer.add(2);
        listContainer.add(3);

        Iterator iterator = listContainer.iterator();
        int result;
        int i = 0;

        while (iterator.hasNext()) {
            i++;
            result = (int) iterator.next();
            assertThat(result, is(i));
        }

    }

    /**
     * When next element not exists in empty container throw no such element exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextElementNotExistsInEmptyContainerThrowNoSuchElementException() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();

        Iterator iterator = listContainer.iterator();
        iterator.next();

    }

    /**
     * When next element not exists in not empty throw no such element exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextElementNotExistsInNotEmptyThrowNoSuchElementException() {
        LinkedListContainer<Integer> listContainer = new LinkedListContainer<>();
        listContainer.add(1);
        Iterator iterator = listContainer.iterator();
        iterator.next();
        iterator.next();

    }

}