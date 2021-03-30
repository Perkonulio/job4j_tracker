package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

public class FullSearchTest {
    @Test
    public void exctractNumberTest() {
        List<Task> list = List.of(new Task("1", "Desc1"),
                new Task("2", "Desc2"), new Task("1", "Desc1"));
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSearch.extractNumber(list), is(expected));

    }
}