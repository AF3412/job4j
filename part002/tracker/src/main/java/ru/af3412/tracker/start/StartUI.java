package ru.af3412.tracker.start;

/**
 * The type Start ui.
 */
public class StartUI {

	private Input input;

    /**
     * Instantiates a new Start ui.
     *
     * @param input the input
     */
    public StartUI(Input input){
		this.input = input;
	}

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
/* Main method*/
	public static void main(String[] args) {

		Input input = new ConsoleInput();
		new StartUI(input).init();
		
	}

	private Tracker tracker = new Tracker();

    /**
     * Init.
     */
    public void init() {

		MenuTracker menu = new MenuTracker(this.input, tracker);
		menu.fillAction();

		do {
			menu.show();
			int key = Integer.valueOf(input.ask("Select: "));
			menu.select(key);
		} while (!"y".equals(this.input.ask("Exit? (y): ")));
		
	}

}