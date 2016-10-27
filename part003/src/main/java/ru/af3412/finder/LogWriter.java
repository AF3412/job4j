package ru.af3412.finder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The type Log writer.
 *
 * @author Filatov Alexander
 * @since 27.10.2016
 */
public class LogWriter {

    private File fileLog;

    /**
     * Instantiates a new Log writer.
     *
     * @param fileLog the file log
     */
    public LogWriter(File fileLog) {
        this.fileLog = fileLog;
    }


    /**
     * This method writing log file.
     *
     * @param log is string be recorded in the log file
     */
    protected void write(String log) {
        try (PrintWriter pw = new PrintWriter(fileLog)) {
            pw.print(log);
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
