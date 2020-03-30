package ru.af3412.magnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.is;

/**
 * The type Store sql test.
 */
public class StoreSQLTest {

    private final Config config = new Config();

    /**
     * Config init.
     */
    @Before
    public void configInit() {
        config.init();
    }

    /**
     * When create store sql then if db not exist create it.
     */
    @Test
    public void whenCreateStoreSQLThenIfDBNotExistCreateIt() {
        try (StoreSQL storeSQL = new StoreSQL(config)) {
            File db = new File("db.sqlite3");

            Assert.assertTrue(db.exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * When generate new entry that entry exist in table.
     */
    @Test
    public void whenGenerateNewEntryThatEntryExistInTable() {
        int size = 1000;
        List<Entry> result = null;
        try (StoreSQL storeSQL = new StoreSQL(config)) {
            storeSQL.generate(size);

            result = storeSQL.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(result);
        Assert.assertThat(size, is(result.size()));
    }

}