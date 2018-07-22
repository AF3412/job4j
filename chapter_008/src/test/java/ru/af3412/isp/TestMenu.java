package ru.af3412.isp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Test menu.
 *
 * @author Filatov Alexander
 * @since 01.03.2017
 */
public class TestMenu {

    /**
     * When add item to menu then item is added.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddItemToMenuThenItemIsAdded() throws Exception {

        Item item1 = new Item("1");
        Item item2 = new Item("1.1");
        Item item3 = new Item("1.2");
        item1.addItem(item2);
        item1.addItem(item3);

        Menu menu = new Menu();
        menu.setPrefix("-");
        boolean result = menu.addItem(item1);

        assertThat(result, is(true));

    }

    /**
     * Print.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPrintMenu() throws Exception {
        Menu menu = new Menu();
        Item item1 = new Item("1.");
        Item item2 = new Item("1.1.");
        Item item3 = new Item("1.2.");
        Item item4 = new Item("2.");
        Item item5 = new Item("3.");
        item1.addItem(item2);
        item1.addItem(item3);
        menu.setPrefix("-");
        menu.addItem(item1);
        menu.addItem(item4);
        menu.addItem(item5);
        StringBuilder sb = new StringBuilder();
        String expectation = sb.append("-1.").append(System.lineSeparator()).
                append("--1.1.").append(System.lineSeparator()).
                append("--1.2.").append(System.lineSeparator()).
                append("-2.").append(System.lineSeparator()).
                append("-3.").append(System.lineSeparator()).
                toString();

        String result = menu.print();

        assertThat(result, is(expectation));

    }

}