package ru.af3412.isp;

import ru.af3412.isp.interfaces.PrintItemSimple;
import ru.af3412.isp.interfaces.PrintItemWithPrefix;

import java.util.ArrayList;

/**
 * The type Print menu.
 *
 * @author Filatov Alexander
 * @since 27.02.2017
 */
public class PrintItemsSimple implements PrintItemSimple, PrintItemWithPrefix {

    @Override
    public String print(Item item) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(item).append(System.lineSeparator());
        for (Item subMenu : item.getItems()) {
            stringBuilder.append(subMenu).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String print(ArrayList<Item> items, Prefix prefix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix).append(items).append(System.lineSeparator());
        for (Item subMenu : items.getItems()) {
            stringBuilder.append(prefix).append(subMenu).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
