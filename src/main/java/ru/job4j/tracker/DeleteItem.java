package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Delete item");
        int number = input.askInt("Select id");
        if (tracker.delete(number)) {
           out.println("Delete sucsessful");
        } else {
            out.println("Delete failed");
        }
        return true;
    }
}
