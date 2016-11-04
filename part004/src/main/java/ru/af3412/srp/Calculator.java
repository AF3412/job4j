package ru.af3412.srp;

/**
 * The type Calculator.
 *
 * @author Filatov Alexander
 * @since 31.10.2016
 */
public class Calculator {

    /**
     * Calculate double.
     *
     * @param first     the first
     * @param operation the operation
     * @param second    the second
     * @return the double
     */
    public double calculate(double first, String operation, double second) {
        double result= 0;
        if (operation.equals("+")) {
            result = (first + second);
        } else if(operation.equals("-")) {
            result = (first - second);
        } else if(operation.equals("*")) {
            result = (first * second);
        } else if(operation.equals("/")) {
            result = (first / second);
        }

        return result;
    }

}