package ru.job4j.tracker;

public class EditItem implements UserAction{
    private final Output out;

    public EditItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("------Edit item------");
        int number = input.askInt("Select id");
        String name = input.askStr("Select name:");
        Item item = new Item(name);
        if(tracker.replace(number, item)){
            out.println("Replace sucseffful");
        } else {
            out.println("Replace failed");
        }
        return true;
    }
}
