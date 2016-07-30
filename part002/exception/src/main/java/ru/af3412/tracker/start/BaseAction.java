package ru.af3412.tracker.start;

public abstract class BaseAction implements UserAction {

	public String actionName;

	public BaseAction(String actionName){
		this.actionName = actionName;
	}

	public abstract int key();

	public abstract void execute(Input input, Tracker tracker);

	public String info(){
		return String.format("%s. %s", this.key(), this.actionName);
	}

}