package ru.af3412.isp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Print menu test.
 *
 * @author Filatov Alexander
 * @since 27.02.2017
 */
public class PrintItemsTestSimple {

    /**
     * When print menu gets simple item then return string with item name.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenPrintMenuGetsSimpleItemThenReturnStringWithItemName() throws Exception {

        PrintItemsSimple printItems = new PrintItemsSimple();
        Item item_1 = new Item("1.", "1.");
        StringBuilder stringBuilder = new StringBuilder();

        String expectation = stringBuilder.append("1.").append(System.lineSeparator()).toString();

        String result = printItems.print(item_1);

        assertThat(result, is(expectation));

    }

    /**
     * When print menu gets sub menu item then return string with item name.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenPrintMenuGetsSubMenuItemThenReturnStringWithItemName() throws Exception {

        PrintItemsSimple printItems = new PrintItemsSimple();
        Item item_1 = new Item("1.", "1.");
        Item item_2 = new Item("1.1.", "1.1.");
        Item item_3 = new Item("1.2.", "1.2.");
        StringBuilder stringBuilder = new StringBuilder();

        item_1.addItem(item_2);
        item_1.addItem(item_3);

        stringBuilder.append("1.").append(System.lineSeparator());
        stringBuilder.append("1.1.").append(System.lineSeparator());
        stringBuilder.append("1.2.").append(System.lineSeparator());
        String expectation = stringBuilder.toString();

        String result = printItems.print(item_1);

        assertThat(result, is(expectation));

    }

}