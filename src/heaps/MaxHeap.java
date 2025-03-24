package heaps;

public class MaxHeap {
    public static void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(array, i);
        }
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();
        
        MyHeap heap = new MyHeap();
        for (int item: array)
            heap.insert(item);

        while (k - 1 > 0) {
            heap.remove();
            k--;
        }

        return heap.max();
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int indexA, int indexB) {
        array[indexA] = array[indexA] ^ array[indexB];
        array[indexB] = array[indexA] ^ array[indexB];
        array[indexA] = array[indexA] ^ array[indexB];
    }
}
