package ru.af3412.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionCalculator {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        return IntStream.range(start, end)
                .mapToObj(index -> func.apply((double) index))
                .collect(Collectors.toList());
    }

}