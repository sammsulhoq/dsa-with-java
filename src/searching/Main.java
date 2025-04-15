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
        System.out.print(", [last position] " + (endTime - startTime) + " ns");
    }
}
