package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> level(List<Student> list, int bound) {
        return list.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Student::getScore)
                        .thenComparing(Student::getName))
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
