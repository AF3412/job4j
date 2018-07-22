package ru.af3412.tracker;

/**
 * The interface Input.
 */
public interface Input {

    /**
     * Ask string.
     *
     * @param question the question
     * @return the string
     */
    String ask(String question);

    /**
     * Ask int.
     *
     * @param question the question
     * @param range    the range
     * @return the int
     */
    int ask(String question, int[] range);

}