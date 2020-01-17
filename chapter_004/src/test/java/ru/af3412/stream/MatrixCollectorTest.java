package ru.af3412.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixCollectorTest {

    @Test
    public void whenCollectMatrixIntegerThenReturnListInteger() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        MatrixCollector matrixCollector = new MatrixCollector();
        List<Integer> expected = List.of(1, 2, 3, 4);
        List<Integer> result = matrixCollector.collect(matrix);

        assertThat(result, is(expected));
    }

}