package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StartUITest{

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] userActions = { new CreateAction(), new Exit()};
        new StartUI().init(in, tracker, userActions);
        assertThat(tracker.findAll()[0].getName(), is("item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String replaceName = "New Item name";
        Input in = new StubInput(new String[] {"0", item.getId() + "", replaceName, "1"});
        UserAction[] actions = {new EditItem(), new Exit()};
        new StartUI().init(in, tracker, actions);
        item = tracker.findById(item.getId());
        assertThat(item.getName(), is(replaceName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", item.getId() + "", "1"});
        UserAction[] userAction = {new DeleteItem(), new Exit()};
        new StartUI().init(in, tracker, userAction);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

}