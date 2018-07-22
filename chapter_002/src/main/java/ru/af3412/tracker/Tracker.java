package ru.af3412.tracker;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Tracker.
 */
public class Tracker {

    private ArrayList<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * Add.
     *
     * @param name        the name
     * @param description the description
     */
    protected void add(String name, String description) {
        Item item = new Item(name, description, this.generateId(), System.currentTimeMillis());
        this.items.add(item);
    }

    /**
     * Add comments.
     *
     * @param item    the item
     * @param comment the comment
     */
    protected void addComments(Item item, String comment) {
        item.addComments(comment);
    }

    /**
     * Item edit.
     *
     * @param item        the item
     * @param name        the name
     * @param description the description
     * @param comment     the comment
     */
    protected void itemEdit(Item item, String name, String description, String comment) {
        item.setName(name);
        item.setDescription(description);
        this.addComments(item, comment);
    }

    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    protected void delete(String id) {
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index) != null && items.get(index).getId().equals(id)) {
                items.remove(index);
                break;
            }
        }
    }

    /**
     * Get all item [ ].
     *
     * @return the item [ ]
     */
    protected ArrayList<Item> getAll() {

        return this.items;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}