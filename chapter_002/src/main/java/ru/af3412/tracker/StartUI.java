package ru.af3412.tracker;

/**
 * The type Start ui.
 */
public class StartUI {

    private Input input;
    private ITracker tracker = new Tracker();
    /**
     * Instantiates a new Start ui.
     *
     * @param input the input
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    /* Main method*/
    public static void main(String[] args) {

        Input input = new ValidateInput();
        new StartUI(input).init();

    }

    /**
     * Init.
     */
    public void init() {

        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillAction();
        int[] range = menu.getRange();

        do {
            menu.show();
            menu.select(input.ask("Select: ", range));
        } while (!"y".equals(this.input.ask("Exit? (y): ")));

    }

}