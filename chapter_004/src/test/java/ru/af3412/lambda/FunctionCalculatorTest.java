package ru.af3412.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FunctionCalculatorTest {

    private final FunctionCalculator calc = new FunctionCalculator();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = calc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = calc.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        double delta = 0.0001D;
        List<Double> result = calc.diapason(5, 8, x -> Math.log(x) + 1);
        List<Double> expected = Arrays.asList(2.60944D, 2.79175D, 2.94591D);
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(result.get(i) - expected.get(i) < delta);
        }
    }

}