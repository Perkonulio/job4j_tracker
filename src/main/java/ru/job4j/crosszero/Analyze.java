package ru.job4j.crosszero;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(subjects -> subjects.getSubjects().stream())
                .flatMap(value -> Stream.of(value.getScore()))
                .mapToDouble(value -> value)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream){
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                .parallelStream()
                .mapToDouble(Subject::getScore)
                .average().getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(subject -> subject.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getLessonName, Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(value -> new Tuple(value.getKey(), value.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                .parallelStream()
                .mapToDouble(Subject::getScore)
                .sum())).max(new CompareTuple()).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(subject -> subject.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getLessonName, Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(value -> new Tuple(value.getKey(), value.getValue()))
                .max(new CompareTuple()).orElse(null);
    }

}
