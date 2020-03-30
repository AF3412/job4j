package ru.af3412.magnit;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * The type Config test.
 */
public class ConfigTest {


    /**
     * When init db config then check exist db and create it if need.
     */
    @Test
    public void whenInitDBConfigThenCheckExistDBAndCreateItIfNeed() {
        String url = "jdbc:sqlite:db.sqlite3";
        Config config = new Config();
        config.init();

        String exist = config.get("sqlite.url");

        assertThat(url, is(exist));
    }

}