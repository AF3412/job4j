package ru.af3412.ocp;

import ru.af3412.srp.Calculator;

/**
 * The type Calculator trig.
 *
 * @author Filatov Alexander
 * @since 07.11.2016
 */
public class CalculatorTrig extends Calculator {

    /**
     * Calculate double for trigonometry function.
     *
     * @param first     the first
     * @param operation the operation
     * @return the double
     */
    public double calculate(double first, String operation) {
        double result = 0;
        if (operation.equals("sin")) {
            result = Math.sin(first);
        } else if (operation.equals("cos")) {
            result = Math.cos(first);
        } else if (operation.equals("tan")) {
            result = Math.tan(first);
        }
        return result;
    }

}
