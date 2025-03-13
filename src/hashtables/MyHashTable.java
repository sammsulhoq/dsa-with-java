package hashtables;

import java.util.LinkedList;

public class MyHashTable {
    private class Item {
        private int key;
        private String value;

        public Item(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Item>[] items;
    public MyHashTable() {
        this.items = new LinkedList[5];
    }

    public void put(int key, String value) {
        var index = hash(key);
        if (items[index] == null) {
            items[index] = new LinkedList<>();
        } else {
            for (var eachEntry : items[index]) {
                if (eachEntry.key == key)
                    eachEntry.value = value;
            }
        }

        items[index].addLast(new Item(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        if (items[index] == null)
            throw new IllegalStateException();

        for (var eachEntry: items[index]) {
            if (eachEntry.key == key)
                return eachEntry.value;
        }

        return null;
    }

    public void remove(int key) {
        var index = hash(key);
        if (items[index] != null) {
            for (var eachEntry: items[index])
                if (eachEntry.key == key){
                    items[index].remove(eachEntry);
                    break;
                }
        }
    }

    private int hash(int key) {
        return key % items.length;
    }
}