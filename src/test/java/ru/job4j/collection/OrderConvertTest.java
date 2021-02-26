package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> list = new ArrayList<>();
        list.add(new Order("5543", "Helena"));
        HashMap<String, Order> map = OrderConvert.process(list);
        assertThat(map.get("5543"), is(new Order("5543", "Helena")));

    }

}