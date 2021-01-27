package ru.job4j.tracker;

import org.junit.Test;

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