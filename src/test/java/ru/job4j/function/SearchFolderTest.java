package ru.job4j.function;

import org.junit.Test;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchFolderTest {

    @Test
    public void filterSize() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        Predicate<Folder> pred = folder
                -> folder.getSize() > 100;
        List<Folder> expected = List.of(new Folder("fix", 110));
        List<Folder> result = SearchFolder.filterList(list, pred);
        assertThat(result, is(expected));
    }

    @Test
    public void filterName() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        Predicate<Folder> pred = folder
                -> folder.getName().contains("bug");
        List<Folder> expected = List.of(new Folder("bug", 75), new Folder("bug", 90));
        List<Folder> result = SearchFolder.filterList(list, pred);
        assertThat(result, is(expected));
    }
}