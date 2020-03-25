package ru.af3412.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * The type Ui test.
 */
public class UITest {

    /**
     * When add item that add in array.
     */
    @Test
    public void whenAddItemThatAddInArray() {

        ITracker tracker = new Tracker();
        String testName = "first task";
        String testDesc = "first desc";

        tracker.add(new Item("first task", "first desc"));
        Item item = tracker.getAll().get(0);

        Assert.assertThat(item.getName(), is(testName));
        Assert.assertThat(item.getDescription(), is(testDesc));

    }

    /**
     * When add comment that add comment in item.
     */
    @Test
    public void whenAddCommentThatAddCommentInItem() {

        ITracker tracker = new Tracker();
        String testComment = "first comment";
        tracker.add(new Item("second task", "second desc"));
        Item item = tracker.getAll().get(0);

        tracker.addComments(item, "first comment");
        Comment comment = item.getAllComments()[0];

        Assert.assertThat(comment.getText(), is(testComment));

    }

    /**
     * When edit item that item edit in array.
     */
    @Test
    public void whenEditItemThatItemEditInArray() {

        ITracker tracker = new Tracker();
        String testName = "edit task";
        String testDesc = "edit desc";
        String testComment = "edit comment";

        tracker.add(new Item("third task", "third desc"));
        Item item = tracker.getAll().get(0);
        tracker.itemEdit(item, "edit task", "edit desc", "edit comment");
        item = tracker.getAll().get(0);
        Comment comment = item.getAllComments()[0];

        Assert.assertThat(item.getName(), is(testName));
        Assert.assertThat(item.getDescription(), is(testDesc));
        Assert.assertThat(comment.getText(), is(testComment));

    }

    /**
     * When delete item that item delete in array.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDeleteItemThatItemDeleteInArray() {

        ITracker tracker = new Tracker();
        String testId;
        tracker.add(new Item("fourth task", "fourth desc"));
        Item item = tracker.getAll().get(0);
        testId = item.getId();

        tracker.delete(testId);

        Assert.assertNull(tracker.getAll().get(0));
    }

}