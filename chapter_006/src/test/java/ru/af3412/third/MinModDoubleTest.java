package ru.af3412.third;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The type Min mod double test.
 *
 * @author Filatov Alexander
 * @since 17.09.2016
 */
public class MinModDoubleTest {
    /**
     * Min value.
     */
    @Test
    public void minValue() {

        double min = -Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        double average = 0.0;
        double testMin;

        MinModDouble mmd = new MinModDouble();
        mmd.array = new double[]{min, average, max};
        testMin = mmd.minValue();

        assertThat(testMin, is(min));

    }

}