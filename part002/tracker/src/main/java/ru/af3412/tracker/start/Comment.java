package ru.af3412.tracker.start;

public class Comment {

	private String text;

	public Comment() {
	}

	public Comment(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	/* reload method toString() */
	@Override public String toString() {
		return String.format("Comment: %s", this.text);
	}

}