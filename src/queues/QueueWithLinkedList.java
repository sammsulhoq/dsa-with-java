package queues;

import java.util.LinkedList;

public class QueueWithLinkedList<T> {
    private final LinkedList<T> queue;

    public QueueWithLinkedList() {
        queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
