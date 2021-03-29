package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListToMapTest {

    @Test
    public void whenDuplicate() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(30, "Surname3")
        );
        Map<String, Student> expected = Map.of(
                "Surname2", new Student(20, "Surname2"),
                "Surname3", new Student(30, "Surname3")
        );
        ListToMap listToMap = new ListToMap();
        Map<String, Student> list = listToMap.listFormateToMap(students);
        assertThat(list, is(expected));

    }

}