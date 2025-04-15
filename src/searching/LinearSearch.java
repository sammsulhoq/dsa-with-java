package searching;

public class LinearSearch {
    public int serach(int[] array, int target) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == target)
                return i;

        return  -1;
    }
}
