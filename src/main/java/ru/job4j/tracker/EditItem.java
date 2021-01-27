package ru.job4j.tracker;

public class EditItem implements UserAction{
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int number = input.askInt("Edit item" + System.lineSeparator() +"Select id");
        String name = input.askStr("Select name:");
        Item item = new Item(name);
        if(tracker.replace(number, item)){
            System.out.println("Replace sucseffful");
        } else {
            System.out.println("Replace failed");
        }
        return true;
    }
}
