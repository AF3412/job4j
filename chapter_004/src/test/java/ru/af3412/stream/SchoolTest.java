package ru.af3412.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

}