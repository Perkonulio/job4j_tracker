package ru.job4j.sort;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MachineTest {

    @Test
    public void testChange() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] result = machine.change(100, 100);
        assertThat(expected, is(result));
    }

    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] result = machine.change(50, 35);
        assertThat(expected, is(result));
    }

    @Test
    public void when100by35() {
        Machine machine = new Machine();
        int[] expected = {10, 10, 10, 10, 10, 10, 5};
        int[] result = machine.change(100, 35);
        assertThat(expected, is(result));
    }
}