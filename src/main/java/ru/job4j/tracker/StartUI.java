package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init (Scanner scanner, Tracker tracker) {
        boolean run = true;
        while(run) {
            this.showMenu();
            System.out.print("Select: ");
            int num = Integer.parseInt(scanner.nextLine());
            if(num == 0) {
                System.out.println("Create new Item");
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if(num == 1) {
                System.out.println("Show all items");
                Item[] array = tracker.findAll();
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
            } else if(num == 2) {
                System.out.println("Edit item");
                System.out.println("Select id");
                int selectId = Integer.parseInt(scanner.nextLine());
                System.out.println("Select Name");
                String selectName = scanner.nextLine();
                Item name = new Item(selectName);
                if(tracker.replace(selectId, name)) {
                    System.out.println("Replacement successful");
                } else {
                    System.out.println("Replacement failed");
                }
            } else if(num == 3) {
                System.out.println("Delete item");
                System.out.println("Select id");
                int numDel = Integer.parseInt(scanner.nextLine());
                if(tracker.delete(numDel)) {
                    System.out.println("Delete successful");
                } else {
                    System.out.println("Delete failed");
                }
            } else if(num == 4) {
                System.out.println("Find item by ID");
                System.out.println("Select id");
                int numSelect = Integer.parseInt(scanner.nextLine());
                Item itemById = tracker.findById(numSelect);
                if(itemById != null) {
                    System.out.println(itemById);
                } else {
                    System.out.println("ID не найден");
                }
            } else if(num == 5) {
                System.out.println("Find items by name");
                System.out.println("Enter item name:");
                String name = scanner.nextLine();
                Item[] findItem = tracker.findByName(name);
                if(findItem.length != 0) {
                    for (int i = 0; i < findItem.length; i++) {
                        System.out.println(findItem[i]);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
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

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Scanner scanner = new Scanner(System.in);
        new StartUI().init(scanner, tracker);
    }
}
