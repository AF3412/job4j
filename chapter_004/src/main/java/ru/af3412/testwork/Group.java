package ru.af3412.testwork;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Group {

    /*
      Метод возвращает сгрупперованный по интересам map,
      в котором ключ это хобби студента, а значение - список студентов, которые увлекаются данным хобби.
    */
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getUnits().stream()
                        .map(unit -> new Holder(unit, student.getName())))
                .collect(Collectors.groupingBy(Holder::getKey, Collectors.mapping(Holder::getValue, Collectors.toSet())));
    }

}
