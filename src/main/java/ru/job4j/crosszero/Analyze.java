package ru.job4j.crosszero;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        int counter = 0;
        return stream.flatMap(subjects -> Stream.of(subjects.getSubjects())
                .flatMap(value -> Stream.of(value.get(counter))))
                .mapToInt(value -> Stream.of(value.getScore()))
                .average()
                .orElse(0);

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return List.of();
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }

}
