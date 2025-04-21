package searching;

public class TernarySearch {
    public int searchIter(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        int mid1 = left + ((right - left) / 3);
        int mid2 = right - ((right - left) / 3);

        while (mid1 <= mid2) {
            if (target == array[mid1])
                return mid1;

            if (target == array[mid2])
                return mid2;

            if (target < array[mid1])
                right = mid1 - 1;

            if (target > array[mid2])
                left = mid2 + 1;

            if (target > array[mid1] && target < array[mid2] ) {
                left = mid1 + 1;
                right = mid2 - 1;
            }

            mid1 = left + ((right - left) / 3);
            mid2 = right - ((right - left) / 3);
        }

        return -1;
    }

    public int serachRecr(int[] array, int target) {
        return searchRecr(array, target, 0, array.length - 1);
    }

    private int searchRecr(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (target == array[mid1])
            return mid1;

        if (target == array[mid2])
            return mid2;

        if (target < array[mid1])
            return searchRecr(array, target, left, mid1 - 1);

        if (target > array[mid2])
            return searchRecr(array, target, mid2 + 1, right);

        return searchRecr(array, target, mid1 + 1, mid2 - 1);
    }
}
