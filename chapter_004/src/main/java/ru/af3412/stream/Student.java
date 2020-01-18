package ru.af3412.stream;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private final Integer score;
    private final String lastName;

    public Student(int score) {
        this.score = score;
        this.lastName = "";
    }

    public Student(String lastName) {
        this.lastName = lastName;
        this.score = 0;
    }

    public Student(int score, String lastName) {
        this.score = score;
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Student o) {
        return o.getScore() - this.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;

        if (!score.equals(student.score)) {
            return false;
        }
        return Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        int result = score;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
