package ru.af3412.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {

    private static final Logger LOG = LogManager.getLogger(TrackerSQLTest.class.getName());

    /**
     * When connected with DB method returning true
     */
    @Test
    public void checkConnection() {
        try (TrackerSQL sql = new TrackerSQL()) {
            assertThat(sql.init(), is(true));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * When add item that add in database.
     */
    @Test
    public void whenAddItemThatAddInDataBase() {
        String testName = "first task";
        String testDesc = "first desc";
        Item item = null;
        try (TrackerSQL trackerSQL = new TrackerSQL()) {
            trackerSQL.init();
            item = trackerSQL.add(new Item("first task", "first desc"));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        Assert.assertNotNull(item);
        Assert.assertFalse(item.getId().isEmpty());
        Assert.assertThat(item.getName(), Is.is(testName));
        Assert.assertThat(item.getDescription(), Is.is(testDesc));
    }

    /**
     * When getAll that return all items from database
     */
    @Test
    public void whenGetAllItemThatReturnAllItemsInDataBase() {
        List<Item> items = null;
        try (TrackerSQL trackerSQL = new TrackerSQL()) {
            trackerSQL.init();
            trackerSQL.add(new Item("second task", "second description"));

            items = trackerSQL.getAll();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        Assert.assertNotNull(items);
    }

    /**
     * When get item by id that return this item
     */
    @Test
    public void whenFindItemByIdThatReturnItem() {
        Item item = new Item("third task", "third description");
        Item result = null;
        try (TrackerSQL trackerSQL = new TrackerSQL()) {
            trackerSQL.init();
            String id = trackerSQL.add(item).getId();

            result = trackerSQL.findById(id);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        Assert.assertThat(item.getName(), is(result.getName()));
        Assert.assertThat(item.getDescription(), is(result.getDescription()));
    }

    /**
     * When get item by id that return this item
     */
    @Test
    public void whenDeleteItemThatItItemNotFindInDB() {
        Item result = null;
        try (TrackerSQL trackerSQL = new TrackerSQL()) {
            trackerSQL.init();
            Item item = trackerSQL.add(new Item("four task", "four description"));

            trackerSQL.delete(item.getId());

            result = trackerSQL.findById(item.getId());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        Assert.assertNull(result);
    }

}