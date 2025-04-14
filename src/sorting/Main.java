package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(numbers);
        System.out.print("Bubble Sort: ");
        System.out.println(Arrays.toString(numbers));

        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(numbers);
        System.out.print("Selection Sort: ");
        System.out.println(Arrays.toString(numbers));

        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(numbers);
        System.out.print("Insertion Sort: ");
        System.out.println(Arrays.toString(numbers));

        numbers = new int[]{7, 3, 1, 4, 6, 2, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numbers);
        System.out.print("Merge Sort: ");
        System.out.println(Arrays.toString(numbers));
    }
}
