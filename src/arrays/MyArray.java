package arrays;

public class MyArray {
    private int[] values;
    private byte head;

    public MyArray(int capacity) {
        values = new int[capacity];
        head = -1;
    }

    public void insert(int newValue) {
        if (head == values.length - 1) {
            int[] temp = new int[values.length * 2];

            for (int i = 0; i < values.length; i++) {
                temp[i] = values[i];
            }

            values = temp;
        }

        values[++head] = newValue;
    }

    public void removeAt(int index) {
        if (index < 0 || index > head)
            throw new IndexOutOfBoundsException("Invalid index!");

        for (int i = index; i < head; i++)
            values[i] = values[i + 1];

        values[head--] = 0;
    }

    public int indexOf(int valueToBeFound) {
        for (int i = 0; i < head; i++) {
            if (values[i] == valueToBeFound) {
                return i;
            }
        }

        return -1;
    }

    public int max() {
        int largest = 0;
        for (int value: values) {
            if (value > largest)
                largest = value;
        }

        return largest;
    }

    public void reverse() {
        for(int i = head; i > -1; i--) {
            System.out.println(values[i]);
        }
    }

    public void print() {
        if (head > -1) {
            for (int i = 0; i < head + 1; i++) {
                System.out.println(values[i]);
            }
        }
    }

    // TODO
    public int[] insersect(int[] anotherArray) {
        return anotherArray;
    }

    public void insertAt(int value, int index) {}
}
