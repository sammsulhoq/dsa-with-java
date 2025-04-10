package sorting;

/**
 * Implements BubbleSort algorithm where the largest value
 * "bubbles-up" to the end of the array
 *
 * Optimizations:
 * 1. 'isSorted' is set to 'true' before the inner loop to mark
 *      that the array is sorted. If a swapping happens then it
 *      is marked as false and thus we have to go for next pass,
 *      otherwise we can return and avoid unnecessary iterations.
 * 2. After every iteration, we will have a highest value at the
 *      end of the array, thus we can ignore that by setting the
 *      final condition as 'array.length - i'
 *
 */
public class BubbleSort {
    public void sort(int[] array) {
        boolean isSorted;
        for (var i = 0; i < array.length; i++) {
            isSorted = true;

            for (var j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }

            if (isSorted)
                return;
        }
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
