package ru.job4j.tracker;

public class DeleteItem implements UserAction{
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int number = input.askInt("Delete item" + System.lineSeparator() +"Select id");
        if(tracker.delete(number)) {
            System.out.println("Delete sucsessful");
        } else {
            System.out.println("Delete failed");
        }
        return true;
    }
}
