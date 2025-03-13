package hashtables;

import java.util.LinkedList;

public class MyHashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public MyHashTable(int capacity) {
        this.entries = new LinkedList[capacity];
    }

    public void put(int k, String v){
        var index = hash(k);
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        } else {
            var bucket = entries[index];
            for (var entry: bucket)
                if (entry.key == k) {
                    entry.value = v;
                    return;
                }

            var entry = new Entry(k, v);
            entries[index].addLast(entry);
        }
    }

    public String get(int k){
        var index = hash(k);
        var bucket = entries[index];
        if (bucket != null) {
            for (var entry: bucket)
                if (entry.key == k)
                    return entry.value;

        }

        return null;
    }

    public void remove(int k){
        var index = hash(k);
        var bucket = entries[index];
        if (bucket == null)
            throw new IllegalStateException();

        for (var entry: bucket)
            if (entry.key == k) {
                bucket.remove(entry);
                return;
            }

        throw new IllegalStateException();
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
