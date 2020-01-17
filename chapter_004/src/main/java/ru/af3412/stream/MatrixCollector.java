package ru.af3412.stream;

import java.util.List;
import java.util.stream.Collectors;

public class MatrixCollector {

    /*
        преобразование матрицы в список чисел
    */
    List<Integer> collect(List<List<Integer>> matrix) {
        return matrix
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}