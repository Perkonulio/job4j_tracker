package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

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
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> listFind = new ArrayList<>();
        for(Item itemFind :items) {
            if(itemFind.getName().equals(key)) {
                listFind.add(itemFind);
            }
        }
        return listFind;
    }

    public List<Item> findAll() {
        return items;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < items.size(); i++){
            if(items.get(i).getId() == id) {
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
            items.set(index, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if(index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

}