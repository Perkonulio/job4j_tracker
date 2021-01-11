package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        int sizeResult = 0;
        Item[] resultItem = new Item[size];
        for (int i = 0; i < size; i++) {
            if(items[i].getName().equals(key)) {
                resultItem[sizeResult] = new Item(items[i].getId(), items[i].getName());
                sizeResult++;
            }

        }
        resultItem = Arrays.copyOf(resultItem, sizeResult);
        return resultItem;
    }

    public Item[] findAll() {
        Item[] resultFind = new Item[size];
        int resultSize = 0;
        for (int i = 0; i < size; i++) {
            if(items[i].getName() != null) {
                resultFind[resultSize] = new Item(items[i].getId(), items[i].getName());
                resultSize++;
            }
        }
        resultFind = Arrays.copyOf(resultFind, resultSize);
        return resultFind;
    }

}