package sorting;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] array) {
        if (array.length < 2)
            return;

        int mid = array.length / 2;
        int[] leftArray = new int[mid];

        for (int i = 0; i < mid; i++)
            leftArray[i] = array[i];

        int[] rightArray = new int[array.length - mid];
        for (int i = mid; i < array.length; i++ )
            rightArray[ i - mid] = array[i];

        sort(leftArray);
        sort(rightArray);

        merge(leftArray, rightArray, array);
    }

    private void merge(int[] leftArray, int[] rightArray, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j])
                result[k++] = leftArray[i++];
            else
                result[k++] = rightArray[j++];
        }

        while (i < leftArray.length)
            result[k++] = leftArray[i++];

        while (j < rightArray.length)
            result[k++] = rightArray[j++];
    }
}
