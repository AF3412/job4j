package ru.af3412.testwork;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GroupTest {

    private final static List<Student> STUDENTS = List.of(
            new Student("Alex", Set.of("run", "tennis", "football")),
            new Student("Nick", Set.of("run", "swimming", "basketball")),
            new Student("John", Set.of("basketball"))
    );


    @Test
    public void whenSectionsByUnitThenReturningUnitSelection() {
        Map<String, Set<String>> expected = Map.of(
                "run", Set.of("Alex", "Nick"),
                "tennis", Set.of("Alex"),
                "football", Set.of("Alex"),
                "swimming", Set.of("Nick"),
                "basketball", Set.of("Nick", "John")
        );
        Map<String, Set<String>> result = Group.sections(STUDENTS);
        assertThat(result, is(expected));
    }

}