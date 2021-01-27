package ru.job4j.tracker;

public class ShowAllItem implements UserAction{
    @Override
    public String name() {
        return "Show all item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return true;
    }
}
