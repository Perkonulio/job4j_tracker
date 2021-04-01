package ru.job4j.collegefunc;

import javax.swing.*;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> result = Optional.empty();
        for (Student s : students.keySet()) {
            if (account.equals(s.getAccount())) {
                result = Optional.of(s);
                break;
            }
        }
        return result;
    }

    public Optional<Subject> findBySubjectName(String account, String lessonName) {
        Optional<Subject> result = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = students.get(s.get());
            for (Subject subject : subjects) {
                if (subject.getLessonName().equals(lessonName)) {
                    result = Optional.of(subject);
                    break;
                }
            }
        }
        return result;
    }
}
