package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSort {
    public void sort(int[] array) {
        int maximum = Arrays.stream(array).max().getAsInt();
        int[] countArray = new int[maximum + 1];

        for (var item: array)
            countArray[item]++;

        int k = 0;
        for (int i = 0; i < countArray.length; i++)
            for (int j = 0; j < countArray[i]; j++)
                array[k++] = i;
    }
}
