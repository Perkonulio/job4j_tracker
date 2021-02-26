package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("urgent", 5));
        priorityQueue.put(new Task("middle", 9));
        priorityQueue.put(new Task("low", 8));
        Task result = priorityQueue.take();
        assertThat(result.getDescrip(), is("urgent"));
    }

}