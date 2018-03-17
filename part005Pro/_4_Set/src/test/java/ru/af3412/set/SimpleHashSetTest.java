package ru.af3412.set;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by AF on 15.03.2018.
 */
public class SimpleHashSetTest {

    /**
     * When add one value return true.
     */
    @Test
    public void whenAddOneValueReturnTrue() {
        SimpleHashSet<String> set = new SimpleHashSet<>();

        boolean result = set.add("Тест");

        assertThat(result, is(true));
    }

    /**
     * When add one value get size return size.
     */
    @Test
    public void whenAddOneValueGetSizeReturnSize() {
        SimpleHashSet<String> set = new SimpleHashSet<>();

        set.add("Тест");
        int result =  set.getSize();

        assertThat(result, is(1));
    }

    /**
     * When add two value get size return size.
     */
    @Test
    public void whenAddTwoValueGetSizeReturnSize() {
        SimpleHashSet<String> set = new SimpleHashSet<>();

        set.add("Тест");
        set.add("Тест2");
        int result =  set.getSize();

        assertThat(result, is(2));
    }

    /**
     * When add two same values get size return one.
     */
    @Test
    public void whenAddTwoSameValuesGetSizeReturnOne() {
        SimpleHashSet<String> set = new SimpleHashSet<>();

        set.add("Тест");
        set.add("Тест");
        int result =  set.getSize();

        assertThat(result, is(1));
    }

    /**
     * When remove value get size return size.
     */
    @Test
    public void whenRemoveValueGetSizeReturnSize() {
        SimpleHashSet<String> set = new SimpleHashSet<>();
        set.add("Тест");
        set.add("Тест2");

        set.remove("Тест");
        int result =  set.getSize();

        assertThat(result, is(1));
    }

    /**
     * When set size is full then double size and contains values.
     */
    @Test
    public void whenSetSizeIsFullThenDoubleSizeAndContainsValues() {
        SimpleHashSet<String> set = new SimpleHashSet<>(10);
        set.add("Тест");
        set.add("Тест2");

        boolean result =  set.contains("Тест333");

        assertThat(result, is(false));
    }


}