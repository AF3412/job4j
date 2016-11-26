package ru.af3412.finder;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * The type Validator test.
 *
 * @author Filatov Alexander
 * @since 18.10.2016
 */
public class ValidatorTest {

    /**
     * Test validate parameters is null.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_validate_parameters_is_null() throws Exception {

        String[] args = {};
        boolean expected = false;

        Validator validator = new Validator(args);
        boolean result = validator.validate();

        assertThat(expected, is(result));

    }

    /**
     * Test validate parametres is one.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_validate_parametres_is_one() throws Exception {

        String[] args = {"test.txt"};
        boolean expected = false;

        Validator validator = new Validator(args);
        boolean result = validator.validate();

        assertThat(expected, is(result));

    }

    /**
     * Test validate parametres is true.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_validate_parametres_is_true() throws Exception {

        String[] args = {"-d", "c:\\", "-n", "*.txt", "-m", "-o", "log.txt"};
        boolean expected = true;

        Validator validator = new Validator(args);
        boolean result = validator.validate();

        assertThat(expected, is(result));

    }

    /**
     * Test validate parametres is false.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_validate_parametres_is_false() throws Exception {

        String[] args = {"-ddd", "c:\\", "-n", "*.txt", "-mm", "-oooo", "log.txt"};
        boolean expected = false;

        Validator validator = new Validator(args);
        boolean result = validator.validate();

        assertThat(expected, is(result));

    }


}