package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> set = new TreeSet<>();
        set.add(new User("Pedro", 28));
        set.add(new User("Hulio", 35));
        Iterator<User> it = set.iterator();
        assertThat(it.next(), is(new User("Hulio", 35)));
        assertThat(it.next(), is(new User("Pedro", 28)));
    }

    @Test
    public void whenComparePetrVSIvan() {
        int result = new User("Petr", 32).compareTo(new User("Ivan", 28));
        assertThat(result, is(greaterThan(0)));


    }

}