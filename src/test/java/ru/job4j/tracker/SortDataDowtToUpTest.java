package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SortDataDowtToUpTest {

    @Test
    public void whenFullList() {
        Item item1 = new Item("Pedro");
        Item item2 = new Item("Hulio");
        SortDataDowtToUp sorting = new SortDataDowtToUp();
        List<Item> list = Arrays.asList(item1, item2);
        list.sort(sorting);
        List<Item> listExpected = Arrays.asList(item1, item2);
        assertThat(list, is(listExpected));
    }

}