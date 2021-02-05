package ru.job4j.tracker;

import javax.sound.midi.Track;
import java.util.Arrays;

public final class Tracker {
    private static Tracker instance = null;
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private Tracker() {
    }

    public static Tracker getInstance() {
        if(instance == null) {
            instance =  new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        int sizeResult = 0;
        Item[] resultItem = new Item[size];
        for (int i = 0; i < size; i++) {
            if(items[i].getName().equals(key)) {
                resultItem[sizeResult] = items[i];
                sizeResult++;
            }

        }
        resultItem = Arrays.copyOf(resultItem, sizeResult);
        return resultItem;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if(items[i].getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if(index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if(index != -1) {
            items[id] = null;
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

}