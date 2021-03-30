package ru.job4j.collectionfinal;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartamentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1/ssk2");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk2");
        List<String> result = Departaments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAscSortChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1/ssk2", "k2");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk2", "k2");
        List<String> result = Departaments.fillGaps(input);
        Departaments.sortAsc(result);
        assertThat(result, is(expect));
    }

    @Test
    public void whenDescSortChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1/ssk2", "k2");
        List<String> expect = Arrays.asList("k2", "k1", "k1/sk1", "k1/sk1/ssk2");
        List<String> result = Departaments.fillGaps(input);
        Departaments.sortDesc(result);
        assertThat(result, is(expect));
    }
}