package stacks;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayAsStack {
    private final int[] stack;
    private int head;

    public ArrayAsStack(int size) {
        this.stack = new int[size];
        head = 0;
    }

    public void push(int value) {
        if (head == stack.length)
            throw new IllegalArgumentException("Stack full!");

        stack[head++] = value;
    }

    public int pop() {
        if (head < 0)
            return -1;

        int item = stack[head];
        stack[head--] = 0;
        return item;
    }

    public int peek() {
        return stack[head - 1];
    }

    public boolean isEmpty(){
        return head < 0;
    }

    @Override
    public String toString() {
        var values = Arrays.copyOfRange(stack, 0, head);
        return Arrays.toString(values);
    }
}
