package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(numbers);
        System.out.print("Bubble Sort: ");
        System.out.print(Arrays.toString(numbers));

        long endTime = System.nanoTime();
        System.out.println(", Total time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(numbers);
        System.out.print("Selection Sort: ");
        System.out.print(Arrays.toString(numbers));
        endTime = System.nanoTime();
        System.out.println(", Total time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(numbers);
        System.out.print("Insertion Sort: ");
        System.out.print(Arrays.toString(numbers));
        endTime = System.nanoTime();
        System.out.println(", Total time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numbers);
        System.out.print("Merge Sort: ");
        System.out.print(Arrays.toString(numbers));
        endTime = System.nanoTime();
        System.out.println(", Total time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        System.out.print("Quick Sort: ");
        System.out.print(Arrays.toString(numbers));
        endTime = System.nanoTime();
        System.out.println(", Total time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        CountingSort countingSort = new CountingSort();
        countingSort.sort(numbers);
        System.out.print("Counting Sort: ");
        System.out.print(Arrays.toString(numbers));
        endTime = System.nanoTime();
        System.out.println(", Total time taken: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(numbers, 3);
        System.out.print("Bucket Sort: ");
        System.out.print(Arrays.toString(numbers));
        endTime = System.nanoTime();
        System.out.println(", Total time taken: " + (endTime - startTime) + " ns");
    }
}
