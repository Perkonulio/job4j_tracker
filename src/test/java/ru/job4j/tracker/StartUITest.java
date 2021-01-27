package ru.job4j.tracker;

import org.junit.Test;

import javax.sound.midi.Track;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest{

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] userActions = { new CreateAction(output), new Exit()};
        new StartUI(output).init(in, tracker, userActions);
        assertThat(tracker.findAll()[0].getName(), is("item name"));
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
        UserAction[] userActions = {new ShowAllItem(output), new Exit()};
        new StartUI(output).init(in, tracker, userActions);
        assertThat(tracker.findAll(), is(new Item[] {item1, item2}));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "new Item name";
        Item item = new Item(name);
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", name, "1"});
        UserAction[] userActions = {new FindItemByName(out), new Exit()};
        new StartUI(out).init(in, tracker, userActions);
        assertThat(tracker.findByName(name), is(new Item[] {item}));
    }

    @Test
    public void whenFindId() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "Item name";
        Item item = new Item(name);
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", item.getId() + "", "1"});
        UserAction[] userActions = {new FindItemByID(output), new Exit()};
        new StartUI(output).init(in, tracker, userActions);
        assertThat(tracker.findById(item.getId()), is(item));

    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String replaceName = "New Item name";
        Input in = new StubInput(new String[] {"0", item.getId() + "", replaceName, "1"});
        UserAction[] actions = {new EditItem(output), new Exit()};
        new StartUI(output).init(in, tracker, actions);
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
        UserAction[] userAction = {new DeleteItem(output), new Exit()};
        new StartUI(output).init(in, tracker, userAction);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] userActions = {new Exit()};
        new StartUI(output).init(in, tracker, userActions);
        assertThat(output.toString(), is("Menu" + System.lineSeparator()));
    }



}