package searching;

public class BinarySearch {
    public int searchIter(int[] array, int target) {
        int low = array[0];
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target)
                return mid;

            if (target < array[mid])
                high = mid - 1;

            if (target > array[mid])
                low = mid + 1;
        }

        return -1;
    }

    
}
