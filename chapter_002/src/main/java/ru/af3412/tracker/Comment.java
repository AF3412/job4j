package ru.af3412.tracker;

/**
 * The type Comment.
 */
public class Comment {

    private String text;

    /**
     * Instantiates a new Comment.
     */
    public Comment() {
    }

    /**
     * Instantiates a new Comment.
     *
     * @param text the text
     */
    public Comment(String text) {
        this.text = text;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return this.text;
    }

    /* reload method toString() */
    @Override
    public String toString() {
        return String.format("Comment: %s", this.text);
    }

}