package ru.job4j.collection;


import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenNameUpComparator() {
        Job worker1 = new Job("Hulio", 25);
        Job worker2 = new Job("Pedro", 34);
        CompareNameUp comparator = new CompareNameUp();
        List<Job> list = Arrays.asList(worker1, worker2);
        list.sort(comparator);
        assertThat(list, is(Arrays.asList(worker1, worker2)));
    }

    @Test
    public void whenPriorityUpComparator() {
        Job worker1 = new Job("Hulio", 44);
        Job worker2 = new Job("Pedro", 34);
        ComparePriorityUp comparator = new ComparePriorityUp();
        List<Job> list = Arrays.asList(worker1, worker2);
        list.sort(comparator);
        assertThat(list, is(Arrays.asList(worker2, worker1)));
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
        System.out.println(list);
    }
}