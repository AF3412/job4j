package ru.af3412.testLogger_001;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {

    private static final Logger LOG = LogManager.getLogger(TestLogger.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }

}
