package ru.af3412.magnit;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * The type Start test.
 */
public class StartTest {

    /**
     * When start process with size three return sum element six.
     */
    @Test
    public void whenStartProcessWithSizeThreeReturnSumElementSix() {
        Start start = new Start();
        int result = start.process(2);
        int expected = 3;

        Assert.assertThat(result, is(expected));
    }

    /**
     * When create big size values process ends in less than five minutes.
     */
    @Test(timeout = 300000)
    public void whenCreateBigSizeValuesProcessEndsInLessThanFiveMinutes() {
        new Start().process(10000000);
    }

}