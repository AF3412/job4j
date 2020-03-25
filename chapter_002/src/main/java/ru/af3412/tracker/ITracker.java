package ru.af3412.tracker;

import java.util.ArrayList;

/**
 * The interface Tracker.
 */
public interface ITracker {

    /**
     * Add item.
     *
     * @param item        the item
     * @return the new item
     */
    Item add(Item item);

    /**
     * Add comments.
     *
     * @param item    the item
     * @param comment the comment
     */
    void addComments(Item item, String comment);

    /**
     * Item edit.
     *
     * @param item        the item
     * @param name        the name
     * @param description the description
     * @param comment     the comment
     */
    void itemEdit(Item item, String name, String description, String comment);

    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     */
    Item findById(String id);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);

    /**
     * Gets all.
     *
     * @return the all
     */
    ArrayList<Item> getAll();

}
