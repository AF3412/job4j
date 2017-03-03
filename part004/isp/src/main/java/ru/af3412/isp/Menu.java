package ru.af3412.isp;

import ru.af3412.isp.interfaces.AddItem;
import ru.af3412.isp.interfaces.Print;

import java.util.ArrayList;

/**
 * The type Menu.
 */
public class Menu implements Print, AddItem {

    /**
     * The list of items.
     */
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * The menu prefix.
     */
    private String prefix;

    /**
     * Sets prefix.
     *
     * @param prefix the prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Add item boolean.
     *
     * @param item the item
     * @return the boolean
     */
    public boolean addItem(Item item) {
        return this.items.add(item);
    }

    /**
     * Print string.
     *
     * @return the string
     */
    public String print() {

        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : this.items) {
            stringBuilder.append(item.print(this.prefix));
        }
        return stringBuilder.toString();
    }

}
