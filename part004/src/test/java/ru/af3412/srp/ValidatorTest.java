package ru.af3412.srp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Filatov Alexander
 * @since 01.11.2016
 */
public class ValidatorTest {

    @Test
    public void validate_action_parameters_is_empty() {

        String args = "";
        Validator validator = new Validator();
        boolean expected = false;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    @Test
    public void validate_action_parameters_is_plus() {

        String args = "+";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    @Test
    public void validate_action_parameters_is_minus() {

        String args = "-";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    @Test
    public void validate_action_parameters_is_multi() {

        String args = "*";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    @Test
    public void validate_action_parameters_is_div() {

        String args = "/";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    @Test
    public void validate_action_parameters_is_another() {

        String args = "sdf43";
        Validator validator = new Validator();
        boolean expected = false;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    @Test
    public void validate_numbers_parametrs_is_number() {
        String args = "1";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkNumber(args);

        assertThat(expected, is(result));
    }

    @Test
    public void validate_numbers_parametrs_is_not_number() {
        String args = "a";
        Validator validator = new Validator();
        boolean expected = false;

        boolean result = validator.checkNumber(args);

        assertThat(expected, is(result));
    }

}