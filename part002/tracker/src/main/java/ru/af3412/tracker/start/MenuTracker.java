package ru.af3412.tracker.start;

/**
 * The type Edit item.
 */
class EditItem implements UserAction {

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
		}
		else {
			System.out.println("Item not found");
		}
	}

	public String info() {
		return String.format("%s. %s", this.key(), "EditItem Item");
	}

}

/**
 * The type Menu tracker.
 */
public class MenuTracker {

	private Input input;
	private Tracker tracker;
	private UserAction[] action = new UserAction[5];

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
		this.action[0] = this.new AddItem();
		this.action[1] = new MenuTracker.ShowItem();
		this.action[2] = new EditItem();
		this.action[3] = new FindId();
		this.action[4] = new DeleteItem();
	}

    /**
     * Select.
     *
     * @param key the key
     */
    public void select(int key) {
		this.action[key].execute(this.input, this.tracker);
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

	private class AddItem implements UserAction {

		public int key() {
			return 0;
		}

		public void execute(Input input, Tracker tracker) {

		String name = input.ask("Please input task name: ");
		String description = input.ask("Please input task description: ");
		tracker.add(name, description);

		}

		public String info() {
			return String.format("%s. %s", this.key(), "Add the new Item");
		}

	}

	private static class ShowItem implements UserAction {

		public int key() {
			return 1;
		}

		public void execute(Input input, Tracker tracker) {

			for (Item item : tracker.getAll()) {
				if (item != null) {
					System.out.println(String.format("%s, %s, %s", item.getName(), item.getDescription(), item.getId()));
				}
			}

		}

		public String info() {
			return String.format("%s. %s", this.key(), "Show all Item");
		}

	}

	private class FindId implements UserAction {

		public int key() {
			return 3;
		}

		public void execute(Input input, Tracker tracker) {

			String id = input.ask("Please input id: ");
			for (Item item : tracker.getAll()){
				if ((item != null) && (item.getId().equals(id))) {
					System.out.print("Name: " + item.getName() + "; ");
					System.out.print("Description: " + item.getDescription() + "; ");
					System.out.print("Id: " + item.getId());
					System.out.print(item.getAllComments());
				} 
			}

		}

		public String info() {
			return String.format("%s. %s", this.key(), "Show item by id");
		}

	}

	private class DeleteItem implements UserAction {

		public int key() {
			return 4;
		}

		public void execute(Input input, Tracker tracker) {

			String id = input.ask("Please input id: ");
			tracker.delete(id);

		}

		public String info() {
			return String.format("%s. %s", this.key(), "Delete Item");
		}

	}

}