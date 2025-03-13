package queues;

import java.util.Arrays;

public class ArrayQueue {
    private final int[] queue;
    private int front, end, count;

    public ArrayQueue(int size) {
        this.queue = new int[size];
        front = end = 0;
    }

    public boolean isEmpty() {
        return front == 0 && end == 0;
    }

    public void enqueue(int value) {
        if (count == queue.length)
            throw new IllegalStateException();

        queue[end] = value;
        end = (end + 1) % queue.length;     // To make the array circular so that we are not wasting empty spaces
        count++;
    }

    public int dequeue() {
        if (front >= end)
            throw new IllegalStateException();

        int value = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;

        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
