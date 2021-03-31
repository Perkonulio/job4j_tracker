package ru.job4j.collegefunc;

import java.util.Objects;

public class Subject {
    private String lessonName;
    private int score;

    public Subject(String lessonName, int score) {
        this.lessonName = lessonName;
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
