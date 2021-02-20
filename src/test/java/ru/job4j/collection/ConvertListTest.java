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
        List<int[]> list = new ArrayList<>();
        ConvertList convertList = new ConvertList();
        list.add(new int[] {1, 2});
        list.add(new int[] {3, 4});
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(convertList.convert(list), is(expected));
    }

}