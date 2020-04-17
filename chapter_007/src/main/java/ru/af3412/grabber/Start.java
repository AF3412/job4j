package ru.af3412.grabber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class Start {

    private static final Logger LOG = LogManager.getLogger(Start.class.getName());

    public static void main(String[] args) {
        Start start = new Start();
        start.runJob();
    }

    private void runJob() {
        try {
            Properties properties = getGrabberProperties();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDetail job = newJob(GrabJob.class).build();

            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(properties.getProperty("cron.time")))
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException se) {
            LOG.error("Error scheduler {}", se.getMessage(), se);
        } catch (IOException ioe) {
            LOG.error("Error load properties file: {}", ioe.getMessage(), ioe);
        }
    }

    private Properties getGrabberProperties() throws IOException {
        try (InputStream is = Start.class.getClassLoader().getResourceAsStream("grabber.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            return properties;
        }
    }

    private static class GrabJob implements Job {
        @Override
        public void execute(JobExecutionContext context) {
            Grab grabber = new GrabberSqlRuToMemStore();
            Parse sqlRuParser = new SqlRuParse();
            Store store = new MemStore();
            grabber.init(sqlRuParser, store);
        }
    }

}
