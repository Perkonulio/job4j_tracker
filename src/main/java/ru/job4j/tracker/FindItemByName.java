package ru.job4j.tracker;

import java.util.List;

public class FindItemByName implements UserAction{
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("------Find items by name------");
        String name = input.askStr("Enter item name:");
        List<Item> itemArray = tracker.findByName(name);
        if(itemArray.size() != 0) {
            for (Item item : itemArray) {
                out.println(item);
            }
        } else {
            out.println("Applications with this name were not found");
        }
        return true;
    }
}
