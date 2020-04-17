package ru.af3412.grabber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Logger LOG = LogManager.getLogger(Config.class.getName());
    private final Properties values = new Properties();

    /**
     * Init.
     */
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("grabber.properties")) {
            if (in == null) {
                LOG.error("Error load file 'grabber.properties'");
                throw new IllegalStateException("Error load file 'grabber.properties'");
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
