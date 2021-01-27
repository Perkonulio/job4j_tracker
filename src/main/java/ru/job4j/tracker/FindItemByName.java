package ru.job4j.tracker;

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
        Item[] itemArray = tracker.findByName(name);
        if(itemArray.length != 0) {
            for (int i = 0; i < itemArray.length; i++) {
                System.out.println(itemArray[i]);
            }
        } else {
            System.out.println("Applications with this name were not found");
        }
        return true;
    }
}
