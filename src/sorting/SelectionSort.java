package sorting;

/**
 * Implements SelectionSort for sorting the elements
 * in ascending order
 */
public class SelectionSort {
    public void sort(int[] array) {
        for (var i = 0; i < array.length; i++) {
            int smallestIndex = i;

            for (var j = i; j < array.length; j++)
                if (array[j] < array[smallestIndex])
                    smallestIndex = j;

            swap(array, i, smallestIndex);
        }
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
