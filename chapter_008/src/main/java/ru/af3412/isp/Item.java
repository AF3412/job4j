package ru.af3412.isp;

import ru.af3412.isp.interfaces.AddItem;
import ru.af3412.isp.interfaces.PrintPrefix;

import java.util.ArrayList;

/**
 * The type Item.
 */
public class Item implements PrintPrefix, AddItem {

    /**
     * The Item name.
     */
    private final String name;

    /**
     * The list of subMenu.
     */
    private ArrayList<Item> subItems = new ArrayList<>();

    /**
     * Constructor
     * Instantiates a new Item.
     *
     * @param name the name
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Add item boolean.
     *
     * @param item the item
     * @return the boolean
     */
    public boolean addItem(Item item) {
        return this.subItems.add(item);
    }

    /**
     * Print string.
     *
     * @param prefix the prefix
     * @return the string
     */
    public String print(String prefix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s%s%n", prefix, this.name));
        for (Item item : this.subItems) {
            stringBuilder.append(prefix);
            stringBuilder.append(item.print(prefix));
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return (this.name);
    }

}