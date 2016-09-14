package ru.af3412.first;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Filatov Alexander
 * @since 14.09.2016
 */
public class CheckNumberTest {

    @Test
    public void integerTest() {

        int num = 2;
        String text = "This is an even number";

        CheckNumber cn = new CheckNumber(num);

        assertThat(cn.checked(), is(text));

    }

    @Test
    public void notIntegerTest() {

        int num = 1;
        String text = "This is an odd number";

        CheckNumber cn = new CheckNumber(num);

        assertThat(cn.checked(), is(text));

    }

}