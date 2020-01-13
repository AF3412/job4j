package ru.af3412.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    /*
     * Filter method for school classroom
     * */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students
                .stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

}
