package ru.af3412.finder;

/**
 * The type Validator.
 *
 * @author Filatov Alexander
 * @since 18.10.2016 This class checked parameters
 */
public class Validator {

    /**
     * @param args is init options for program.
     */
    private String[] args;

    private String searchOption;
    private String searchFile;
    private String nameLogFile;
    private String searchDir;

    /**
     * Constructor
     *
     * @param args is init options for program.
     */
    public Validator(String[] args) {

        this.args = args;

    }

    /**
     * Gets search option.
     *
     * @return the search option
     */
    public String getSearchOption() {
        return searchOption;
    }

    /**
     * Gets search file.
     *
     * @return the search file
     */
    public String getSearchFile() {
        return searchFile;
    }

    /**
     * gets search directory
     *
     * @return the search directory
     */
    public String getSearchDir() {
        return searchDir;
    }

    /**
     * Gets name log file.
     *
     * @return the name log file
     */
    public String getNameLogFile() {
        return nameLogFile;
    }

    /**
     * Validate boolean.
     *
     * @return true if all arguments is right and set
     */
    protected boolean validate() {
        boolean result = false;
        if (this.args.length == 7) {
            if (
                    (this.args[0].equals("-d"))
                            && (this.args[2].equals("-n"))
                            && ((this.args[4]).equals("-m") || (this.args[4]).equals("-f") || (this.args[4]).equals("-r"))
                            && (this.args[5].equals("-o"))
            ) {
                setOption();
                result = true;
            }
        }

        return result;
    }

    /**
     * Set searchOption and nameLogFile from init args.
     */
    private void setOption() {
        this.searchDir = this.args[1];
        this.searchFile = this.args[3];
        this.searchOption = this.args[4];
        this.nameLogFile = this.args[6];
    }


    /**
     * Usage string.
     *
     * @return the string
     */
    protected String usage() {
        return ("Usage: java -jar find.jar -d c:\\ -n *.txt -m -o log.txt \n"
                + "-d is logic search directory \n"
                + "-n is file, or mask or regular expressions \n"
                + "-f find at the full name, -m find at the mask, -r find at the regular expression \n"
                + "-o write search result to file ");
    }


}
