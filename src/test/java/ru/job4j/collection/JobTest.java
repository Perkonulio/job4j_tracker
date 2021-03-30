package ru.job4j.collection;


import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenNameUpComparator() {
        CompareNameUp comparator = new CompareNameUp();
        List<Job> list = Arrays.asList(
                new Job("Hulio", 25),
                new Job("Pedro", 34)
        );
        list.sort(comparator);
        assertThat(list, is(List.of(
                new Job("Hulio", 25),
                new Job("Pedro", 34)))
        );
    }

    @Test
    public void whenPriorityUpComparator() {
        Job worker1 = new Job("Hulio", 44);
        Job worker2 = new Job("Pedro", 34);
        ComparePriorityUp comparator = new ComparePriorityUp();
        List<Job> list = Arrays.asList(worker1, worker2);
        list.sort(comparator);
        assertThat(list, is(List.of(worker2, worker1)));
    }

    @Test
    public void whenPriorityDownComparator() {
        Job worker1 = new Job("Hulio", 25);
        Job worker2 = new Job("Pedro", 34);
        ComparePriorityDown comparator = new ComparePriorityDown();
        List<Job> list = Arrays.asList(worker1, worker2);
        list.sort(comparator);
        assertThat(list, is(Arrays.asList(worker2, worker1)));

    }

    @Test
    public void whenNameDowmComparator() {
        Job worker1 = new Job("Hulio", 25);
        Job worker2 = new Job("Pedro", 34);
        CompareNameDown comparator = new CompareNameDown();
        List<Job> list = Arrays.asList(worker1, worker2);
        list.sort(comparator);
        assertThat(list, is(Arrays.asList(worker2, worker1)));

    }

    @Test
    public void whenComplexComparator() {
        Job worker1 = new Job("Pedro", 25);
        Job worker2 = new Job("Pedro", 34);
        ComparePriorityUp comparePriorityUp = new ComparePriorityUp();
        CompareNameUp compareNameUp = new CompareNameUp();
        List<Job> list = Arrays.asList(worker1, worker2);
        list.sort(compareNameUp.thenComparing(comparePriorityUp));
        assertThat(list, is(Arrays.asList(worker1, worker2)));
    }
}