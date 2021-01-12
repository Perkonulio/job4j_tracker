package ru.job4j.tracker;
import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Pavel");
        Item item2 = new Item("Michael");
        Item item3 = new Item("Pedro");
        Item item4 = new Item("Hulio");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.replace(3, item4);
        System.out.println(Arrays.toString(tracker.findByName("Hulio")));
    }
}
