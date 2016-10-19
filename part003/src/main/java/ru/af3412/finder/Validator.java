package ru.af3412.finder;

/**
 * @author Filatov Alexander
 * @since 18.10.2016
 * This class checked parameters
 */

public class Validator {

    /**
     * @param args is init options for program.
     */
    private String[] args;

    /**
     * Constructor
     *
     * @param args is init options for program.
     */
    public Validator(String[] args) {

        this.args = args;

    }

    /**
     * @return true if all arguments is right
     */
    protected boolean validate() {
        boolean result = false;
        if (this.args.length == 7) {
            if (
                    (this.args[0].equals("-d")) &&
                    (this.args[2].equals("-n")) &&
                    ((this.args[4]).equals("-m") || (this.args[4]).equals("-f") || (this.args[4]).equals("-r")) &&
                    (this.args[5].equals("-o"))
               ) {
                result = true;
            }
        }

        return result;
    }

    protected String usage() {
        return ("Usage: java -jar find.jar -d c:\\ -n *.txt -m -o log.txt \n" +
                "-d is start search directory \n" +
                "-n is file, or mask or regular expressions \n" +
                "-f find at the full name, -m find at the mask, -r find at the regular expression \n" +
                "-o write search result to file ");
    }




}
