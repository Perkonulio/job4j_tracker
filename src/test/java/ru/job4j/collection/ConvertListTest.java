package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {

    @Test
    public void whenTwoList() {
        List<int[]> list = List.of(
                new int[]{1, 2},
                new int[]{3, 4}
        );
        ConvertList convertList = new ConvertList();
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(convertList.convert(list), is(expected));
    }

}