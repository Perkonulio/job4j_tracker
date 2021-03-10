package ru.job4j.tracker;

import org.junit.Test;

import javax.sound.midi.Track;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "item name", "1"});
        Tracker tracker = new Tracker();
        List<UserAction> userActions = Arrays.asList(new CreateAction(output), new Exit());
        new StartUI(output).init(in, tracker, userActions);
        assertThat(tracker.findAll().get(0).getName(), is("item name"));
    }

    @Test
    public void whenShowAllAction() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "1"});
        Item item1 = new Item("Hulio");
        Item item2 = new Item("Pedro");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        List<UserAction> userActions = Arrays.asList(new ShowAllItem(output), new Exit());
        new StartUI(output).init(in, tracker, userActions);
        String ls = System.lineSeparator();
        assertThat(output.toString(), is("Menu" + ls + "------Show all item------" + ls + item1
         + ls + item2 + ls + "Menu" + ls));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "new Item name";
        Item item = new Item(name);
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", name, "1"});
        List<UserAction> userActions = Arrays.asList(new FindItemByName(out), new Exit());
        new StartUI(out).init(in, tracker, userActions);
        String ls = System.lineSeparator();
        assertThat(out.toString(), is("Menu" + ls + "------Find items by name------"
                 + ls +  item + ls + "Menu" + ls));
    }

    @Test
    public void whenFindId() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "Item name";
        Item item = new Item(name);
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", item.getId() + "", "1"});
        List<UserAction> userActions = Arrays.asList(new FindItemByID(output), new Exit());
        new StartUI(output).init(in, tracker, userActions);
        String ls = System.lineSeparator();
        assertThat(output.toString(), is("Menu" + ls + "------Find item by ID------"
                + ls + item + ls + "Menu" + ls));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String replaceName = "New Item name";
        Input in = new StubInput(new String[] {"0", item.getId() + "", replaceName, "1"});
        List<UserAction> userActions = Arrays.asList(new EditItem(output), new Exit());
        new StartUI(output).init(in, tracker, userActions);
        item = tracker.findById(item.getId());
        assertThat(item.getName(), is(replaceName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", item.getId() + "", "1"});
        List<UserAction> userActions = Arrays.asList(new DeleteItem(output), new Exit());
        new StartUI(output).init(in, tracker, userActions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        List<UserAction> userActions = Arrays.asList(new Exit());
        new StartUI(output).init(in, tracker, userActions);
        assertThat(output.toString(), is("Menu" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1", "0"});
        Tracker tracker = new Tracker();
        List<UserAction> userActions = Arrays.asList(new Exit());
        new StartUI(out).init(in, tracker, userActions);
        assertThat(out.toString(), is(String.format(
                "Menu%n"
                + "Wrong input, u can select: 0.. 0%n"
                + "Menu%n")));
    }
}