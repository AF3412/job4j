package ru.af3412.tracker;

import java.util.Arrays;
import java.util.Objects;

/**
 * The type Item.
 */
public class Item {

    private String name;
    private String description;
    private String id;
    private long dateCreate;
    private int positionComments = 0;
    private Comment[] comments = new Comment[10]; // new comments

    /**
     * Instantiates a new Item.
     */
    public Item() {
    }

    /**
     * Instantiates a new Item.
     *
     * @param name        the name
     * @param description the description
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Instantiates a new Item.
     *
     * @param name        the name
     * @param description the description
     * @param id          the id
     * @param dateCreate  the date create
     */
    public Item(String name, String description, String id, long dateCreate) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.dateCreate = dateCreate;
    }

    /* reload method toString() */
    @Override
    public String toString() {
        return String.format("Name: %s; Description: %s; Id: %s", this.name, this.description, this.id);
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets description.
     *
     * @param desc the desc
     */
    public void setDescription(String desc) {
        this.description = desc;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Gets date create.
     *
     * @return the date create
     */
    public long getDateCreate() {
        return this.dateCreate;
    }

    /**
     * Add comments.
     *
     * @param comment the comment
     */
    public void addComments(String comment) {
        comments[positionComments++] = (new Comment(comment));
    }

    /**
     * Get all comments comment [ ].
     *
     * @return the comment [ ]
     */
    public Comment[] getAllComments() {
        Comment[] result = new Comment[positionComments];
        for (int index = 0; index != positionComments; index++) {
            result[index] = this.comments[index];
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return dateCreate == item.dateCreate
                && positionComments == item.positionComments
                && Objects.equals(name, item.name)
                && Objects.equals(description, item.description)
                && Objects.equals(id, item.id)
                && Arrays.equals(comments, item.comments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, description, id, dateCreate, positionComments);
        result = 31 * result + Arrays.hashCode(comments);
        return result;
    }
}