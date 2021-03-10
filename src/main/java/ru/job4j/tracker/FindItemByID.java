package ru.job4j.tracker;

public class FindItemByID implements UserAction {
    private final Output out;

    public FindItemByID(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("------Find item by ID------");
        int number = input.askInt("Select id");
        Item item = tracker.findById(number);
        if (item != null) {
            out.println(item);
        } else {
            out.println("ID not found");
        }
        return true;
    }
}
