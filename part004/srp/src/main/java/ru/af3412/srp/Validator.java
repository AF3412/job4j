package ru.af3412.srp;


import java.util.Scanner;

/**
 * The type Validator.
 *
 * @author Filatov Alexander
 * @since 31.10.2016
 */
public class Validator {

    /**
     * to do
     * 1. Add double first and second
     * 2. Add method for String->double
     *
     * @param args the args
     * @return the boolean
     */
    public boolean checkMathOperation(String args) {
        boolean result = false;
        if ((args.equals("+")) || (args.equals("-")) || (args.equals("/")) || (args.equals("*"))) {
            result = true;
        }

        return result;
    }

    /**
     * Check number boolean.
     *
     * @param args the args
     * @return the boolean
     */
    public boolean checkNumber(String args) {
        return new Scanner(args).hasNextDouble();
    }

    /**
     * Convert string to double double.
     *
     * @param number the number
     * @return the double
     */
    public double convertStringToDouble(String number) {
        return (new Scanner(number)).nextDouble();
    }
}
