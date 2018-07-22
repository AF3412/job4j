package ru.af3412.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * Created by AF on 21.10.2017.
 */
public class SimpleArrayTest {

    /**
     * When create container should return string.
     */
    @Test
    public void whenCreateContainerShouldReturnString() {

        SimpleArray<String> list = new SimpleArray<>(4);
        list.add("test");

        String result = list.get(0);

        assertThat(result, is("test"));
    }

    /**
     * When create container should return integer.
     */
    @Test
    public void whenCreateContainerShouldReturnInteger() {

        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);

        simpleArray.add(1);
        int result = simpleArray.get(0);

        assertThat(result, is(1));
    }

    /**
     * When create container with string should return string.
     */
    @Test
    public void whenCreateContainerWithStringShouldReturnString() {

        SimpleArray<String> simpleArray = new SimpleArray<>(4);

        simpleArray.add("1");
        String result = simpleArray.get(0);

        assertThat(result, is("1"));
    }

    /**
     * When create container with user should return user.
     */
    @Test
    public void whenCreateContainerWithUserShouldReturnUser() {

        SimpleArray<User> simpleArray = new SimpleArray<>(4);
        User u = new User();
        simpleArray.add(u);

        User result = simpleArray.get(0);

        assertThat(result, is(u));
    }

    /**
     * When update element return new value.
     */
    @Test
    public void whenUpdateElementReturnNewValue() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);

        simpleArray.add(1);
        simpleArray.update(0, 2);
        int result = simpleArray.get(0);

        assertThat(result, is(2));
    }

    /**
     * When delete element return null.
     */
    @Test
    public void whenDeleteElementReturnNull() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);

        simpleArray.add(1);
        simpleArray.delete(0);

        assertNull(simpleArray.get(0));
    }

    /**
     * When out of array size return exception.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenOutOfArraySizeReturnException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(0);
        simpleArray.add(1);
    }

    /**
     * When create container with size ten return size ten.
     */
    @Test
    public void whenCreateContainerWithSizeTenReturnSizeTen() {
        int size = 10;
        SimpleArray<String> simpleArray = new SimpleArray<>(size);
        assertThat(simpleArray.getSize(), is(size));
    }

}
