package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;
    private final List<Item> items = new ArrayList<>();
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
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(id) : null;
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
        List<Item> itemFindAll = new ArrayList<>();
        Collections.copy(itemFindAll, items);
        return itemFindAll;
    }

    private int indexOf(int id) {
        int result = -1;
        for(Item item : items) {
            if(item.getId() == id) {
                result = id;
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
            items.remove(items.get(index));
            return true;
        }
        return false;
    }

}