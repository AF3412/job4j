package ru.af3412.tracker.start;

/**
 * The type Item.
 */
public class Item {

	private String name;
	private String description;
	private String id;
	private long dateCreate;
	private int positionComments = 0;
	private Comment[] comments = new Comment[10]; // new comments

    /**
     * Instantiates a new Item.
     */
    public Item() {
	}

    /**
     * Instantiates a new Item.
     *
     * @param name        the name
     * @param description the description
     * @param id          the id
     * @param dateCreate  the date create
     */
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

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
		this.name = name;
	}

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
		return this.name;
	}

    /**
     * Sets description.
     *
     * @param desc the desc
     */
    public void setDescription(String desc) {
		this.description = desc;
	}

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
		return this.description;
	}

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
		return this.id;
	}

    /**
     * Gets date create.
     *
     * @return the date create
     */
    public long getDateCreate() {
		return this.dateCreate;
	}

    /**
     * Add comments.
     *
     * @param comment the comment
     */
    public void addComments(String comment) {
		comments[positionComments++] = (new Comment(comment));
	}

    /**
     * Get all comments comment [ ].
     *
     * @return the comment [ ]
     */
    public Comment[] getAllComments() {
		Comment[] result = new Comment[positionComments];
		for (int index = 0; index != positionComments; index++) {
			result[index] = this.comments[index];
		}
		return result;
	}

}