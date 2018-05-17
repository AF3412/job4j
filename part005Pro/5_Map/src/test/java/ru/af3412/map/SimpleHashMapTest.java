package ru.af3412.map;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * The type Simple hash map test.
 */
public class SimpleHashMapTest {

    /**
     * When add one value to map get size method return one.
     */
    @Test
    public void whenAddOneValueToMapGetSizeMethodReturnOne() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, "a");
        int result = simpleHashMap.getSize();

        assertThat(result, is(1));
    }

    /**
     * When add value to map get value method return value.
     */
    @Test
    public void whenAddValueToMapGetValueMethodReturnValue() {
        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, "a");

        String result = simpleHashMap.get(1);

        assertThat(result, is("a"));
    }

    /**
     * When add two value to map get size method return two.
     */
    @Test
    public void whenAddTwoValueToMapGetSizeMethodReturnTwo() {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("a", "a");
        simpleHashMap.insert("bb", "bb");

        int result = simpleHashMap.getSize();

        assertThat(result, is(2));
    }

    /**
     * When add several value to map get value method return value.
     */
    @Test
    public void whenAddSeveralValueToMapGetValueMethodReturnValue() {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("a", "a");
        simpleHashMap.insert("bb", "bb");
        String[] expected = new String[]{"a", "bb"};

        String[] result = new String[2];
        result[0] = simpleHashMap.get("a");
        result[1] = simpleHashMap.get("bb");

        assertThat(result, is(expected));
    }

    /**
     * When delete value from map get value method return null.
     */
    @Test
    public void whenDeleteValueFromMapGetValueMethodReturnNull() {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("a", "a");
        simpleHashMap.insert("bb", "bb");

        simpleHashMap.delete("a");

        String result = simpleHashMap.get("a");

        assertNull(result);
    }

    /**
     * When size map is full add new value increase size.
     */
    @Test
    public void whenSizeMapIsFullAddNewValueIncreaseSize() {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>(2);
        simpleHashMap.insert("a", "a");
        simpleHashMap.insert("bb", "bb");
        simpleHashMap.insert("bbc", "bbc");
        int expected = 3;

        int result = simpleHashMap.getSize();

        assertThat(result, is(expected));
    }

}