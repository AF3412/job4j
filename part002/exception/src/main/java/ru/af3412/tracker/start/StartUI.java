package ru.af3412.tracker.start;

public class StartUI {
	
	private Input input;

	public StartUI(Input input){
		this.input = input;
	}

	/* Main method*/
	public static void main(String[] args) {

		Input input = new ValidateInput();
		new StartUI(input).init();
		
	}

	private Tracker tracker = new Tracker();

	public void init() {

		MenuTracker menu = new MenuTracker(this.input, tracker);
		int[] range = menu.getRange();
		menu.fillAction();


		do {
			menu.show();
			menu.select(input.ask("Select: ", range));
		} while (!"y".equals(this.input.ask("Exit? (y): ")));
		
	}

}