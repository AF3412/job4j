package ru.af3412.tracker.start;

import java.util.*;

/**
 * The type Tracker.
 */
public class Tracker {

	private Item[] items = new Item[1];
	private int positionItem = 0;
	private Random RN = new Random();

    /**
     * Add.
     *
     * @param name        the name
     * @param description the description
     */
    protected void add(String name, String description) {
		Item item = new Item(name, description, this.generateId(), System.currentTimeMillis());
		this.items[positionItem++] = item;
		this.items = doubleItems(this.items);
	}

    /**
     * Add comments.
     *
     * @param item    the item
     * @param comment the comment
     */
    protected void addComments(Item item, String comment) {
		item.addComments(comment);
	}

    /**
     * Item edit.
     *
     * @param item        the item
     * @param name        the name
     * @param description the description
     * @param comment     the comment
     */
    protected void itemEdit(Item item, String name, String description, String comment) {
		item.setName(name);
		item.setDescription(description);
		this.addComments(item, comment);
	}

    /**
     * Find by id item.
     *
     * @param id the id
     * @return the item
     */
    protected Item findById(String id){
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

    /**
     * Delete.
     *
     * @param id the id
     */
    protected void delete(String id){
		for (int index = 0; index != items.length; index++) {
			if (items[index] != null && items[index].getId().equals(id)) {
				items[index] = null;
				break;
			}
		}
		sortArray(this.items);
	}

    /**
     * Get all item [ ].
     *
     * @return the item [ ]
     */
    protected Item[] getAll() {
		Item[] result = new Item[positionItem];
		for (int index = 0; index != positionItem; index++){
			result[index] = this.items[index];
		}
		return result;
	}

	private void sortArray(Item[] array) {
		for(int indexA=0; indexA != array.length; indexA++) {
			if(array[indexA] == null) { 
				for(int indexB = indexA + 1; indexB != array.length; indexB++) {
					if(array[indexB] != null) {
						Item temp = array[indexB];
						array[indexB] = array[indexA];
						array[indexA] = temp;
						break;
					}
				}
			}	
		}
	}
	
	private Item[] doubleItems(Item[] items) {
		Item[] tempItems = new Item[items.length * 2];
		for (int index = 0; index!= items.length; index++) { 
			tempItems[index] = items[index];
		}
		return tempItems;
	}

	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

}