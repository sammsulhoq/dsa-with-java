package heaps;

import java.util.Arrays;

public class MyHeap {
    private int[] items;
    private int size;               // To keep track of number of items in heap

    public MyHeap() {
        items = new int[10];
        size = 0;
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = value;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var removedItem = items[0];
        items[0] = items[--size];
        bubbleDown();

        return removedItem;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public int max() { return items[0]; }

    private boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp() {
        var lastItemIndex = size - 1;
        while (lastItemIndex > 0 && items[lastItemIndex] > items[parentIndex(lastItemIndex)]) {
            swap(lastItemIndex, parentIndex(lastItemIndex));

            lastItemIndex = parentIndex(lastItemIndex);
        }
    }

    private void bubbleDown() {
        var rootIndex = 0;
        while (rootIndex <= size && items[rootIndex] < items[leftChildIndex(rootIndex)] && rootIndex < items[rightChildIndex(rootIndex)]) {
            var largerChildIndex = largerChildrenIndex(rootIndex);
            swap(rootIndex, largerChildIndex);

            rootIndex = largerChildIndex;
        }
    }

    private int largerChildrenIndex(int rootIndex) {
        if (!hasLeftChild(rootIndex))
            return rootIndex;

        if (!hasRightChild(rootIndex))
            return leftChildIndex(rootIndex);

        return items[leftChildIndex(rootIndex)] > items[rightChildIndex(rootIndex)]
                ? leftChildIndex(rootIndex)
                : rightChildIndex(rootIndex);
    }

    private void swap(int a, int b) {
        items[a] = items[a] ^ items[b];
        items[b] = items[a] ^ items[b];
        items[a] = items[a] ^ items[b];
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
