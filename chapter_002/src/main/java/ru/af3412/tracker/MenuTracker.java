package ru.af3412.tracker;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * The type Edit item.
 */
class EditItem extends BaseAction {

    /**
     * Instantiates a new Edit item.
     *
     * @param actionName the action name
     */
    EditItem(String actionName) {
        super(actionName);
    }

    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {

        String id = input.ask("Please enter task Id: ");
        Item result = tracker.findById(id);
        if (result != null) {
            String name = input.ask("Please input new task name: ");
            String description = input.ask("Please input new task description: ");
            String comment = input.ask("Please input comment: ");
            tracker.itemEdit(result, name, description, comment);
        } else {
            System.out.println("Item not found");
        }
    }

}

/**
 * The type Menu tracker.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> action = new ArrayList<>();

    /**
     * Instantiates a new Menu tracker.
     *
     * @param input   the input
     * @param tracker the tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Fill action.
     */
    public void fillAction() {
        this.action.add(this.new AddItem("Add Item"));
        this.action.add(new MenuTracker.ShowItem("Show all item"));
        this.action.add(new EditItem("Edit Item"));
        this.action.add(new FindId("Find Id"));
        this.action.add(new DeleteItem("Delete Item"));
    }

    /**
     * Get range int [ ].
     *
     * @return the int [ ]
     */
    public int[] getRange() {
        return IntStream.range(0, this.action.size()).toArray();
    }

    /**
     * Select.
     *
     * @param key the key
     */
    public void select(int key) {
        this.action.get(key).execute(this.input, this.tracker);
    }

    /**
     * Show.
     */
    public void show() {
        for (UserAction action : this.action) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        /**
         * Instantiates a new Add item.
         *
         * @param actionName the action name
         */
        AddItem(String actionName) {
            super(actionName);
        }

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please input task name: ");
            String description = input.ask("Please input task description: ");
            tracker.add(name, description);
        }

    }

    private static class ShowItem extends BaseAction {

        /**
         * Instantiates a new Show item.
         *
         * @param actionName the action name
         */
        ShowItem(String actionName) {
            super(actionName);
        }

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null) {
                    System.out.println(MessageFormat.format("{0}, {1}, {2}", item.getName(), item.getDescription(), item.getId()));
                }
            }
        }

    }

    private class FindId extends BaseAction {

        /**
         * Instantiates a new Find id.
         *
         * @param actionName the action name
         */
        FindId(String actionName) {
            super(actionName);
        }

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please input id: ");
            for (Item item : tracker.getAll()) {
                if ((item != null) && (item.getId().equals(id))) {
                    System.out.print("Name: " + item.getName() + "; ");
                    System.out.print("Description: " + item.getDescription() + "; ");
                    System.out.print("Id: " + item.getId());
                    System.out.print(Arrays.toString(item.getAllComments()));
                }
            }
        }

    }

    private class DeleteItem extends BaseAction {

        /**
         * Instantiates a new Delete item.
         *
         * @param actionName the action name
         */
        DeleteItem(String actionName) {
            super(actionName);
        }

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please input id: ");
            tracker.delete(id);
        }

    }

}