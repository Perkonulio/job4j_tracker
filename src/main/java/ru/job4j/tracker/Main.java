package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Item item = new Item(3, "name");
        System.out.println(item.getCreated().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
        System.out.println(item.toString());
    }
}
