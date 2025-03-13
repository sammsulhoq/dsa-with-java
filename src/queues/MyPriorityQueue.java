package queues;

import java.util.Arrays;

public class MyPriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void insert(int item) {
        if (count == items.length){
            increaseArraySize();
        }

        // Shifting items to the right since we are ordering the values in ascending order
        int i = shiftArrayItemsToRight(item);
        items[i + 1] = item;
        count++;
    }

    public int remove() {
        if (count == 0)
            throw new IllegalStateException();

        return items[--count];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    private int shiftArrayItemsToRight(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i;
    }

    private void increaseArraySize() {
        int[] temp = new int[count + 1];

        for(int i = 0; i < items.length; i++)
            temp[i] = items[i];

        items = temp;
    }
}
