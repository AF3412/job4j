package ru.af3412.finder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Filatov Alexander
 * @since 12.10.2016
 * The base class for file search
 * command line example: -d C:\Users\filatov\job4j\data -n test.txt -f -o log.txt
 *                        0  1                           2  3        4  5  6
 */

public class Find {

    private String[] args;
    private File fileLog;

    /**
     * Constructor
     *
     * @param args is users command line parameters
     */
    public Find(String[] args) {
        this.args = args;
    }

    /**
     * This method checked args and searched file
     */
    protected void find() {
        Validator validator = new Validator(this.args);
        if (validator.validate()) {
            fileLog = new File(args[6]);
            if (args[4].equals("-f")) {
                FindByFullName findByFullName = new FindByFullName(args[3]);
                this.writeLog(findByFullName.find(args[1]));
            }
            else if (args[4].equals("-m")) {
                FindByMask findByMask = new FindByMask(args[3]);
                this.writeLog(findByMask.find(args[1]));
            }

        } else {
            System.out.println(validator.usage());
        }

    }

    /**
     * This method writing log file.
     *
     * @param foundFiles is string with search result
     */
    private void writeLog(String foundFiles) {
        try (PrintWriter pw = new PrintWriter(fileLog)) {
            pw.print(foundFiles);
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}