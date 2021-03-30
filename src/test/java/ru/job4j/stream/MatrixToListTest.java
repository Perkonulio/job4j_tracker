package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixToListTest {

    @Test
    public void whenExpectedTrue() {
        Integer[][] mass = new Integer[][]{
                {1, 2},
                {3, 4}
        };
        List<Integer> expected = List.of(1, 2, 3, 4);
        MatrixToList mat = new MatrixToList();
        List<Integer> listForExpect = mat.matrixToList(mass);
        assertThat(listForExpect, is(expected));
    }
}