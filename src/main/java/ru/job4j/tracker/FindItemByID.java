package ru.job4j.tracker;

public class FindItemByID implements UserAction{
    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int number = input.askInt("Find item by ID" + System.lineSeparator() +"Select id");
        Item item = tracker.findById(number);
        if(item != null) {
            System.out.println(item);
        } else {
            System.out.println("ID not found");
        }
        return true;
    }
}
