package searching;

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
        System.out.print("Binary Search (Iteratively) => ");
        System.out.print("Result: " + binarySearch.searchIter(numbers, 6));
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

        // Binary Search - Recursively
        startTime = System.nanoTime();
        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        binarySearch = new BinarySearch();
        System.out.print("Binary Search (Recursively) => ");
        System.out.print("Result: " + binarySearch.searchRecr(numbers, 6));
        endTime = System.nanoTime();
        System.out.print(" Time taken: [mid position] " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.print(", Result: " + binarySearch.searchRecr(numbers, 2));
        endTime = System.nanoTime();
        System.out.print(", [left half] " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        System.out.print(", Result: " + binarySearch.searchRecr(numbers, 11));
        endTime = System.nanoTime();
        System.out.println(", [right half] " + (endTime - startTime) + " ns");

        // Ternary Search - Iteratively
        startTime = System.nanoTime();
        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        TernarySearch ternarySearch = new TernarySearch();
        System.out.print("Ternary Search (Iteratively) => ");
        System.out.print("Result: " + ternarySearch.searchIter(numbers, 4));
        endTime = System.nanoTime();
        System.out.print(" Time taken: [mid position] " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.print(", Result: " + ternarySearch.searchIter(numbers, 2));
        endTime = System.nanoTime();
        System.out.print(", [left half] " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        System.out.print(", Result: " + ternarySearch.searchIter(numbers, 11));
        endTime = System.nanoTime();
        System.out.println(", [right half] " + (endTime - startTime) + " ns");

        // Ternary Search - Recursively
        startTime = System.nanoTime();
        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ternarySearch = new TernarySearch();
        System.out.print("Ternary Search (Recursively) => ");
        System.out.print("Result: " + ternarySearch.serachRecr(numbers, 4));
        endTime = System.nanoTime();
        System.out.print(" Time taken: [mid position] " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.print(", Result: " + ternarySearch.serachRecr(numbers, 2));
        endTime = System.nanoTime();
        System.out.print(", [left half] " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        System.out.print(", Result: " + ternarySearch.serachRecr(numbers, 11));
        endTime = System.nanoTime();
        System.out.println(", [right half] " + (endTime - startTime) + " ns");

        // Jump Search
        startTime = System.nanoTime();
        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        JumpSearch jumpSearch = new JumpSearch();
        System.out.print("Jump Search => ");
        System.out.print("Result: " + jumpSearch.search(numbers, 4));
        endTime = System.nanoTime();
        System.out.print(" Time taken: [mid position] " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.print(", Result: " + jumpSearch.search(numbers, 2));
        endTime = System.nanoTime();
        System.out.print(", [left half] " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        System.out.print(", Result: " + jumpSearch.search(numbers, 11));
        endTime = System.nanoTime();
        System.out.println(", [right half] " + (endTime - startTime) + " ns");

        // Exponential Search
        startTime = System.nanoTime();
        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        System.out.print("Exponential Search => ");
        System.out.print("Result: " + exponentialSearch.search(numbers, 4));
        endTime = System.nanoTime();
        System.out.print(" Time taken: [mid position] " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        System.out.print(", Result: " + exponentialSearch.search(numbers, 2));
        endTime = System.nanoTime();
        System.out.print(", [left half] " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        System.out.print(", Result: " + exponentialSearch.search(numbers, 11));
        endTime = System.nanoTime();
        System.out.println(", [right half] " + (endTime - startTime) + " ns");
    }
}
