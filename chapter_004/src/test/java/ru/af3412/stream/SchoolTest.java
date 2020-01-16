package ru.af3412.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    private final School school = new School();

    private final List<Student> students = new ArrayList<>() { {
        add(new Student(10));
        add(new Student(20));
        add(new Student(30));
        add(new Student(40));
        add(new Student(50));
        add(new Student(60));
        add(new Student(70));
        add(new Student(80));
        add(new Student(90));
        add(new Student(100));
    } };

    /*
        10А диапазон балла [70: 100];
    */
    @Test
    public void whenFilterFor10AGroupThenClassWithScoreBetween70And100() {
        List<Student> expected = new ArrayList<>() { {
            add(new Student(70));
            add(new Student(80));
            add(new Student(90));
            add(new Student(100));
        } };
        List<Student> result = school
                .collect(students, (student) -> (student.getScore() >= 70 && student.getScore() <= 100));
        assertThat(result, is(expected));
    }

    /*
        10Б диапазон балла [50: 70);
    */
    @Test
    public void whenFilterFor10BGroupThenClassWithScoreBetween50And70() {
        List<Student> expected = new ArrayList<>() { {
            add(new Student(50));
            add(new Student(60));
        } };
        List<Student> result = school
                .collect(students, (student) -> (student.getScore() >= 50 && student.getScore() < 70));
        assertThat(result, is(expected));
    }

    /*
        10B диапазон балла (0: 50);
    */
    @Test
    public void whenFilterFor10CGroupThenClassWithScoreBetween0And50() {
        List<Student> expected = new ArrayList<>() { {
            add(new Student(10));
            add(new Student(20));
            add(new Student(30));
            add(new Student(40));
        } };
        List<Student> result = school
                .collect(students, (student) -> (student.getScore() >= 0 && student.getScore() < 50));
        assertThat(result, is(expected));
    }

    @Test
    public void whenCollectStudentsToMapThenReturnStudentsMap() {
        final List<Student> students = new ArrayList<>() { {
            add(new Student(10, "Иванов"));
            add(new Student(20, "Петров"));
            add(new Student(30, "Сидоров"));
        } };

        final Map<String, Student> expected = new HashMap<>();
        expected.put("Иванов", new Student(10, "Иванов"));
        expected.put("Петров", new Student(20, "Петров"));
        expected.put("Сидоров", new Student(30, "Сидоров"));

        final Map<String, Student> result = school.collectMap(students);

        assertThat(result, is(expected));

    }

    @Test
    public void whenCollectStudentsWithDuplicatesToMapThenReturnStudentsMap() {
        final List<Student> students = new ArrayList<>() { {
            add(new Student(10, "Иванов"));
            add(new Student(10, "Иванов"));
            add(new Student(20, "Петров"));
            add(new Student(30, "Сидоров"));
        } };

        final Map<String, Student> expected = new HashMap<>();
        expected.put("Иванов", new Student(10, "Иванов"));
        expected.put("Петров", new Student(20, "Петров"));
        expected.put("Сидоров", new Student(30, "Сидоров"));

        final Map<String, Student> result = school.collectMap(students);

        assertThat(result, is(expected));

    }

}