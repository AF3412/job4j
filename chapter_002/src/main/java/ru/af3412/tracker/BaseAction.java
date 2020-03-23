package ru.af3412.tracker;

/**
 * The type Base action.
 */
public abstract class BaseAction implements UserAction {

    /**
     * The Action name.
     */
    public String actionName;

    /**
     * Instantiates a new Base action.
     *
     * @param actionName the action name
     */
    public BaseAction(String actionName) {
        this.actionName = actionName;
    }

    public abstract int key();

    public abstract void execute(Input input, ITracker tracker);

    public String info() {
        return String.format("%s. %s", this.key(), this.actionName);
    }

}