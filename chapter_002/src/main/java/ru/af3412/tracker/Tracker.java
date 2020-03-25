package ru.af3412.tracker;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * The type Tracker.
 */
public class Tracker implements ITracker {

    private final ArrayList<Item> items = new ArrayList<>();
    private final static Random RN = new Random();

    /**
     * Add item.
     *
     * @param item        the item
     * @return the new item
     */
    public Item add(Item item) {
        Item newItem = new Item(item.getName(), item.getDescription(), this.generateId(), System.currentTimeMillis());
        this.items.add(newItem);
        return item;
    }

    /**
     * Add comments.
     *
     * @param item    the item
     * @param comment the comment
     */
    public void addComments(Item item, String comment) {
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
    public void itemEdit(Item item, String name, String description, String comment) {
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
    public Item findById(String id) {
        return items.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(String id) {
        items.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .ifPresent(items::remove);
    }

    /**
     * Get all item [ ].
     *
     * @return the item [ ]
     */
    public ArrayList<Item> getAll() {
        return this.items;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}