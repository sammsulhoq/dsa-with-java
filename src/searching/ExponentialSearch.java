package searching;

public class ExponentialSearch {
    public int search(int[] array, int target) {
        int bound = 1;

        while (bound < array.length && array[bound] < target) {
            bound *= 2;
        }

        return searchRecr(array, target, bound / 2, Math.min(bound, array.length - 1));
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
