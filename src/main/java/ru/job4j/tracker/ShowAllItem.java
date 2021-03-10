package ru.job4j.tracker;

import java.util.List;

public class ShowAllItem implements UserAction {
    private final Output out;

    public ShowAllItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("------Show all item------");
        List<Item> array = tracker.findAll();
        for (Item item : array) {
            out.println(item);
        }
        return true;
    }
}
