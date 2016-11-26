package ru.af3412.srp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Validator test.
 *
 * @author Filatov Alexander
 * @since 01.11.2016
 */
public class ValidatorTest {

    /**
     * Validate action parameters is empty.
     */
    @Test
    public void validateActionParametersIsEmpty() {

        String args = "";
        Validator validator = new Validator();
        boolean expected = false;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    /**
     * Validate action parameters is plus.
     */
    @Test
    public void validateActionParametersIsPlus() {

        String args = "+";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    /**
     * Validate action parameters is minus.
     */
    @Test
    public void validateActionParametersIsMinus() {

        String args = "-";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    /**
     * Validate action parameters is multi.
     */
    @Test
    public void validateActionParametersIsMulti() {

        String args = "*";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    /**
     * Validate action parameters is div.
     */
    @Test
    public void validateActionParametersIsDiv() {

        String args = "/";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    /**
     * Validate action parameters is another.
     */
    @Test
    public void validateActionParametersIsAnother() {

        String args = "sdf43";
        Validator validator = new Validator();
        boolean expected = false;

        boolean result = validator.checkMathOperation(args);

        assertThat(expected, is(result));

    }

    /**
     * Validate numbers parametrs is number.
     */
    @Test
    public void validateNumbersParametrsIsNumber() {
        String args = "1";
        Validator validator = new Validator();
        boolean expected = true;

        boolean result = validator.checkNumber(args);

        assertThat(expected, is(result));
    }

    /**
     * Validate numbers parametrs is not number.
     */
    @Test
    public void validateNumbersParametrsIsNotNumber() {
        String args = "a";
        Validator validator = new Validator();
        boolean expected = false;

        boolean result = validator.checkNumber(args);

        assertThat(expected, is(result));
    }

}