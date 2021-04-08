package ru.job4j.crosszero;

import java.util.Objects;

/**
 * POJO для Analyze
 * описывает школьный предмет и имя ученика.
 */
public class Subject {
    private String lessonName;
    private double score;

    public Subject(String lessonName, double score) {
        this.lessonName = lessonName;
        this.score = score;
    }

    public String getLessonName() {
        return lessonName;
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Double.compare(subject.score, score) == 0
                && Objects.equals(lessonName, subject.lessonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonName, score);
    }
}
