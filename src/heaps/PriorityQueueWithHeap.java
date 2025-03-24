package heaps;

public class PriorityQueueWithHeap {
    private MyHeap heap = new MyHeap();

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
