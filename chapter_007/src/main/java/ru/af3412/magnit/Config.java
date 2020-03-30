package ru.af3412.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 * Read and get app.properties file values.
 */
public class Config {

    private static final Logger LOG = LogManager.getLogger(Config.class.getName());
    private final Properties values = new Properties();

    /**
     * Init.
     */
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (in == null) {
                LOG.error("Error load file 'app.properties'");
                throw new IllegalStateException("Error load file 'app.properties'");
            }
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Get string.
     *
     * @param key the key
     * @return the string
     */
    public String get(String key) {
        return this.values.getProperty(key);
    }

}
