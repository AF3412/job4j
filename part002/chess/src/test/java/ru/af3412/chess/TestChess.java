package ru.af3412.chess;

/**
 * JUnit4 test class
 *
 * @author Filatov Alexander
 * @since 05.08.2016
 */

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class TestChess{

    /**
     * Test create class Figure
     */
    @Test
    public void whenCreateNewFigureWithNameFigureReturnHisName() {

        Figure figure = new Figure("Test Name");
        String testName = "Test Name";
        Assert.assertThat(figure.getName(), is(testName));
    }


/*  @Test
    public void whenDeleteItemThatItemDeleteInArray() {

        Tracker tracker = new Tracker();
        String testId = null;
        tracker.add("fourth task", "fourth desc");
        Item item = tracker.getAll()[0];
        testId = item.getId();

        tracker.delete(testId);

        Assert.assertNull(tracker.getAll()[0]);

    }
  */

}
