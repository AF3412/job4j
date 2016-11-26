package ru.af3412.srp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Calculator test.
 *
 * @author Filatov Alexander
 * @since 01.11.2016
 */
public class CalculatorTest {

    /**
     * Calculate add test.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateAddTest() throws Exception {

        double first = 1;
        double second = 1;
        String operation = "+";
        Calculator calc = new Calculator();
        double expected = 2;

        double result = calc.calculate(first, operation, second);

        assertThat(expected, is(result));

    }

    /**
     * Calculate sub test.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateSubTest() throws Exception {

        double first = 1;
        double second = 1;
        String operation = "-";
        Calculator calc = new Calculator();
        double expected = 0;

        double result = calc.calculate(first, operation, second);

        assertThat(expected, is(result));

    }

    /**
     * Calculate multiple test.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateMultipleTest() throws Exception {

        double first = 1;
        double second = 1;
        String operation = "*";
        Calculator calc = new Calculator();
        double expected = 1;

        double result = calc.calculate(first, operation, second);

        assertThat(expected, is(result));

    }

    /**
     * Calculate div test.
     *
     * @throws Exception the exception
     */
    @Test
    public void calculateDivTest() throws Exception {

        double first = 1;
        double second = 1;
        String operation = "/";
        Calculator calc = new Calculator();
        double expected = 1;

        double result = calc.calculate(first, operation, second);

        assertThat(expected, is(result));

    }

}