package ru.job4j.tracker;

import com.sun.jdi.connect.spi.TransportService;
import org.junit.Test;

import java.nio.channels.spi.AbstractSelectionKey;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest{
    @Test
    public void whenAddItem() {
        String[] answer = {"Fix PC"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answer = {
                String.valueOf(item.getId()), "replaced Item"
        };
        StartUI.editItem(new StubInput(answer), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced Item"));
    }

}