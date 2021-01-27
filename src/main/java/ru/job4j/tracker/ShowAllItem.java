package ru.job4j.tracker;

public class ShowAllItem implements UserAction{
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
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return true;
    }
}
