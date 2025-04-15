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

    public int searchRecr(int[] array, int target) {
        return searchRecr(array, target, array[0], array.length - 1);
    }

    private int searchRecr(int[] array, int target, int low, int high) {
        if (high < low)
            return -1;

        int mid = (low + high) / 2;

        if (target == array[mid])
            return mid;

        if (target < array[mid])
            return searchRecr(array, target, low, mid - 1);

        return searchRecr(array, target, mid + 1, high);
    }
}
