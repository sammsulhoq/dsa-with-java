package heaps;

import java.util.Arrays;

public class Basic {
    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        myHeap.insert(10);
        myHeap.insert(5);
        myHeap.insert(17);
        myHeap.insert(4);
        myHeap.insert(22);

        System.out.println(myHeap);

        int item = myHeap.remove();
        System.out.println(myHeap);

        item = myHeap.remove();
        System.out.println(myHeap);

        // Heapsort
        int[] items = {5, 3, 10, 1, 4, 2};
        MyHeap heapForSorting = new MyHeap();
        for (int value: items)
            heapForSorting.insert(value);
        for (int i = 0; i < items.length; i++)
            System.out.println(heapForSorting.remove());

        // Priority Queue implementation
        PriorityQueueWithHeap priorityQueue = new PriorityQueueWithHeap();
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(30);
        System.out.println(priorityQueue);

        // Testing heapify()
        int[] numbers = {5, 3, 8, 4, 1, 2};
        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));

        int[] nums = {5, 3, 10, 1, 4, 2};
        System.out.println(MaxHeap.getKthLargest(nums, 3));
    }
}
