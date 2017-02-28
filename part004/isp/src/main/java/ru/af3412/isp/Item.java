package ru.af3412.isp;

import java.util.ArrayList;

/**
 * The type Item.
 *
 * @author Filatov Alexander
 * @since 21.02.2017
 */
public class Item {

    private final String name;

    private final String id;

    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Instantiates a new Item.
     *
     * @param name the name
     * @param id   the id
     */
    public Item(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /*@Override
    public String print(ArrayList<Item> items) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this).append("\n");
        for (Item item : items) {
            stringBuilder.append(item).append("\n");
        }
        return stringBuilder.toString();
    }*/

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    @Override public String toString(){
        return (this.name);
    }

}
