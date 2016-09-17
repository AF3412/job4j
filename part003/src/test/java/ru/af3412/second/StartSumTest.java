package ru.af3412.second;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Filatov Alexander
 * @since 17.09.2016
 */
public class StartSumTest {

    @Test
    public void testMethodSummWithTwoInteger() {

        StartSum ss = new StartSum();

        ss.number[0] = 1;
        ss.number[1] = 0;

        String testValue = "Sum: 1";

        assertThat(ss.summ(), is(testValue));

    }



}