package searching;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // Linear Search
        int[] numbers = { 7, 9, 1, 4, 6, 2, 3 };
        LinearSearch linearSearch = new LinearSearch();
        System.out.println(linearSearch.serach(numbers, 7));
        long endTime = System.nanoTime();
        System.out.print("Linear Search => ");
        System.out.print("Time taken: [1st position] " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.print(linearSearch.serach(numbers, 3));
        endTime = System.nanoTime();
        System.out.println(", [last position] " + (endTime - startTime) + " ns");

        // Binary Search - Iteratively
        startTime = System.nanoTime();
        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        BinarySearch binarySearch = new BinarySearch();
        System.out.print("Binary Search => ");
        System.out.print(", Result: " + binarySearch.searchIter(numbers, 6));
        endTime = System.nanoTime();
        System.out.print(" Time taken: [mid position] " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.print(", Result: " + binarySearch.searchIter(numbers, 2));
        endTime = System.nanoTime();
        System.out.print(", [left half] " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        System.out.print(", Result: " + binarySearch.searchIter(numbers, 11));
        endTime = System.nanoTime();
        System.out.println(", [right half] " + (endTime - startTime) + " ns");
    }
}
