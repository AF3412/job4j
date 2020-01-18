package ru.af3412.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /*
    Collect students list to map, with last name is key
    * */
    Map<String, Student> collectMap(List<Student> students) {
        return students
                .stream()
                .distinct()
                .collect(Collectors.toMap(Student::getLastName, student -> student));
    }

    /*
    Collect students list to sorted list with score more bound
    */
    List<Student> levelOf(List<Student> students, int bound) {
        return students
                .stream()
                .sorted(Comparator.nullsLast(Student::compareTo))
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }

}
