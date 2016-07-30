package ru.af3412.tracker.start;

public class Item {

	private String name;
	private String description;
	private String id;
	private long dateCreate;
	private int positionComments = 0;
	private Comment[] comments = new Comment[10]; // new comments

	public Item() {
	}

	public Item(String name, String description, String id, long dateCreate) {
		this.name = name;
		this.description = description;
		this.id = id;
		this.dateCreate = dateCreate;
	}

	/* reload method toString() */
	@Override public String toString(){
		return String.format("Name: %s; Description: %s; Id: %s", this.name, this.description, this.id);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public String getDescription() {
		return this.description;
	}

	public String getId() {
		return this.id;
	}

	public long getDateCreate() {
		return this.dateCreate;
	}

	public void addComments(String comment) {
		comments[positionComments++] = (new Comment(comment));
	}

	public Comment[] getAllComments() {
		Comment[] result = new Comment[positionComments];
		for (int index = 0; index != positionComments; index++) {
			result[index] = this.comments[index];
		}
		return result;
	}

}