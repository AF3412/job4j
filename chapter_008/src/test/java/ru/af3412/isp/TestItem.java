package ru.af3412.isp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Test item.
 *
 * @author Filatov Alexander
 * @since 01.03.2017
 */
public class TestItem {

    /**
     * The item.
     */
    private Item item;

    /**
     * SetUp test.
     */
    @Before
    public void setUpTest() {
        this.item = new Item("Item");
    }

    /**
     * When add item then item added in array list items.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddItemThenItemAddedInArrayListItems() throws Exception {

        Item itemTest = new Item("ItemTest");

        boolean result = item.addItem(itemTest);

        assertThat(result, is(true));

    }

    /**
     * Test override to string method.
     *
     * @throws Exception the exception
     */
    @Test
    public void testOverrideToStringMethod() throws Exception {

        String expectation = "Item";

        String result = item.toString();

        assertThat(result, is(expectation));
    }

    /**
     * Test print item without sub item.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPrintItemWithoutSubItem() throws Exception {

        String expectation = ("-Item" + System.lineSeparator());

        String result = item.print("-");

        assertThat(result, is(expectation));
    }

    /**
     * Test print item wit sub item witout prefix.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPrintItemWitSubItemWitoutPrefix() throws Exception {

        StringBuilder expBuilder = new StringBuilder();
        String expectation = expBuilder.append("Item").append(System.lineSeparator()).
                append("SubItem").append(System.lineSeparator()).
                toString();
        Item subItem = new Item("SubItem");
        item.addItem(subItem);

        String result = item.print("");

        assertThat(result, is(expectation));
    }

    /**
     * Test print item wit two sub item witout prefix.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPrintItemWitTwoSubItemWitoutPrefix() throws Exception {

        StringBuilder expBuilder = new StringBuilder();
        String expectation = expBuilder.append("Item").append(System.lineSeparator()).
                append("SubItem").append(System.lineSeparator()).
                append("SubItem2").append(System.lineSeparator()).
                toString();
        Item subItem = new Item("SubItem");
        Item subItem2 = new Item("SubItem2");
        item.addItem(subItem);
        item.addItem(subItem2);

        String result = item.print("");

        assertThat(result, is(expectation));
    }

    /**
     * Test print item wit sub item wit prefix.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPrintItemWitSubItemWitPrefix() throws Exception {

        StringBuilder expBuilder = new StringBuilder();
        String expectation = expBuilder.append("-Item").
                append(System.lineSeparator()).append("--SubItem").
                append(System.lineSeparator()).toString();
        Item subItem = new Item("SubItem");
        item.addItem(subItem);

        String result = item.print("-");

        assertThat(result, is(expectation));
    }


}