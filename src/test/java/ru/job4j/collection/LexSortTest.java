package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] put = { "10. Task.", "2. Task.", "1. Task."};
        String[] out = { "1. Task.", "2. Task.", "10. Task."};
        Arrays.sort(put, new LexSort());
        assertThat(put, is(out));
    }

}