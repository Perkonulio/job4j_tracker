package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        String name = input.askStr("Create new Item" + System.lineSeparator() +"Enter name:");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("Show all items");
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        int selectId = input.askInt("Edit item" + System.lineSeparator() +"Select id");
        String selectName = input.askStr("Select Name");
        Item name = new Item(selectName);
        if(tracker.replace(selectId, name)) {
            System.out.println("Replacement successful");
        } else {
            System.out.println("Replacement failed");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int numDel = input.askInt("Delete item" + System.lineSeparator() +"Select id");
        if(tracker.delete(numDel)) {
            System.out.println("Delete successful");
        } else {
            System.out.println("Delete failed");
        }
    }

    public static void findItemByID(Input input, Tracker tracker) {
        int numSelect = input.askInt("Find item by ID" + System.lineSeparator() +"Select id");
        Item itemById = tracker.findById(numSelect);
        if(itemById != null) {
            System.out.println(itemById);
        } else {
            System.out.println("ID не найден");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String name = input.askStr("Find items by name" + System.lineSeparator() + "Enter item name:");
        Item[] findItem = tracker.findByName(name);
        if(findItem.length != 0) {
            for (int i = 0; i < findItem.length; i++) {
                System.out.println(findItem[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init (Input input, Tracker tracker) {
        boolean run = true;
        while(run) {
            this.showMenu();
            int num = input.askInt("Select: ");
            if(num == 0) {
                StartUI.createItem(input, tracker);
            } else if(num == 1) {
                StartUI.showAllItems(tracker);
            } else if(num == 2) {
                StartUI.editItem(input, tracker);
            } else if(num == 3) {
                StartUI.deleteItem(input, tracker);
            } else if(num == 4) {
                StartUI.findItemByID(input, tracker);
            } else if(num == 5) {
                StartUI.findItemByName(input, tracker);
            } else if(num == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program");
    }

}
