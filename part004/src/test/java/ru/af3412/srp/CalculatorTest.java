package ru.af3412.srp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Filatov Alexander
 * @since 01.11.2016
 */
public class CalculatorTest {

    @Test
    public void calculate_add_test() throws Exception {

        double first = 1;
        double second = 1;
        String operation = "+";
        Calculator calc = new Calculator();
        double expected = 2;

        double result = calc.calculate(first, operation , second);

        assertThat(expected, is(result));

    }

    @Test
    public void calculate_sub_test() throws Exception {

        double first = 1;
        double second = 1;
        String operation = "-";
        Calculator calc = new Calculator();
        double expected = 0;

        double result = calc.calculate(first, operation , second);

        assertThat(expected, is(result));

    }

    @Test
    public void calculate_multiple_test() throws Exception {

        double first = 1;
        double second = 1;
        String operation = "*";
        Calculator calc = new Calculator();
        double expected = 1;

        double result = calc.calculate(first, operation , second);

        assertThat(expected, is(result));

    }

    @Test
    public void calculate_div_test() throws Exception {

        double first = 1;
        double second = 1;
        String operation = "/";
        Calculator calc = new Calculator();
        double expected = 1;

        double result = calc.calculate(first, operation , second);

        assertThat(expected, is(result));

    }

}