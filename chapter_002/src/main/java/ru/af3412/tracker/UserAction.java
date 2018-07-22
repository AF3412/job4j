package ru.af3412.tracker;

/**
 * The interface User action.
 */
public interface UserAction {

    /**
     * Key int.
     *
     * @return the int
     */
    int key();

    /**
     * Execute.
     *
     * @param input   the input
     * @param tracker the tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Info string.
     *
     * @return the string
     */
    String info();

}