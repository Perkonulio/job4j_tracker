package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConvertMatrixToListTest {

    @Test
    public void ConvertMatrixTest() {
        ConvertMatrixToList list = new ConvertMatrixToList();
        int[][] input = { {1, 2} , {3, 4}};

        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        assertThat(expect, is(list.toList(input)));
    }

}