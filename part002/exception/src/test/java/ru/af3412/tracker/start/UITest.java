package ru.af3412.tracker.start;

import org.junit.*;

import static org.hamcrest.core.Is.is;

public class UITest {

    @Test
    public void whenAddItemThatAddInArray() {

        Tracker tracker = new Tracker();
        String testName = "first task";
        String testDesc = "first desc";

        tracker.add("first task", "first desc");
        Item item = tracker.getAll()[0];

        Assert.assertThat(item.getName(), is(testName));
        Assert.assertThat(item.getDescription(), is(testDesc));

    }

    @Test
    public void whenAddCommentThatAddCommentInItem() {

        Tracker tracker = new Tracker();
        String testComment = "first comment";
        tracker.add("second task", "second desc");
        Item item = tracker.getAll()[0];

        tracker.addComments(item, "first comment");
        Comment comment = item.getAllComments()[0];

        Assert.assertThat(comment.getText(), is(testComment));

    }

    @Test
    public void whenEditItemThatItemEditInArray() {

        Tracker tracker = new Tracker();
        String testName = "edit task";
        String testDesc = "edit desc";
        String testComment = "edit comment";

        tracker.add("third task", "third desc");
        Item item = tracker.getAll()[0];
        tracker.itemEdit(item, "edit task", "edit desc", "edit comment");
        item = tracker.getAll()[0];
        Comment comment = item.getAllComments()[0];

        Assert.assertThat(item.getName(), is(testName));
        Assert.assertThat(item.getDescription(), is(testDesc));
        Assert.assertThat(comment.getText(), is(testComment));

    }

    @Test
    public void whenDeleteItemThatItemDeleteInArray() {

        Tracker tracker = new Tracker();
        String testId = null;
        tracker.add("fourth task", "fourth desc");
        Item item = tracker.getAll()[0];
        testId = item.getId();

        tracker.delete(testId);

        Assert.assertNull(tracker.getAll()[0]);

    }

}