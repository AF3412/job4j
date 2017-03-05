package ru.af3412.isp;

import java.util.ArrayList;

import ru.af3412.isp.Item;

/**
 * The type Menu.
 *
 * @author Filatov Alexander
 * @since 28.02.2017
 */
public class Menu {

    private Prefix prefix;

    private ArrayList<Item> items;

    public Menu(Prefix prefix) {
        this.prefix = prefix;
    }

    public ArrayList<Item> addItem(Item item) {
        this.items.add(item);
        return this.items;
    }

    public Prefix getPrefix() {
        return this.prefix;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public String print() {
        return (new PrintItemsSimple().print(this.items, prefix));
    }



}
