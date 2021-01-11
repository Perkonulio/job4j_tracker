package ru.job4j.tracker;
import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Pavel");
        Item item2 = new Item("Michael");
        Item item3 = new Item("Pedro");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        System.out.println(Arrays.toString(tracker.findAll()));
        System.out.println(tracker.findById(3));
        System.out.println(Arrays.toString(tracker.findByName("Pavel")));
    }
}
