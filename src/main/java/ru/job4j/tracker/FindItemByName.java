package ru.job4j.tracker;

public class FindItemByName implements UserAction{
    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Find items by name" + System.lineSeparator() + "Enter item name:");
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
