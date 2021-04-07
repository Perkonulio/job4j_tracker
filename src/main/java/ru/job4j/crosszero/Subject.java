package ru.job4j.crosszero;

import java.util.Objects;

/**
 * POJO для Analyze
 * описывает школьный предмет и имя ученика.
 */
public class Subject {
    private String lessonName;
    private int score;

    public Subject(String name, int score) {
        this.lessonName = name;
        this.score = score;
    }

    public String getLessonName() {
        return lessonName;
    }

    public int getScore() {
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
        return score == subject.score
                && Objects.equals(lessonName, subject.lessonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonName, score);
    }
}
