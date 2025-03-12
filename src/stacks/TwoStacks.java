package stacks;

/**
 * Twin stack that supports push, pop and retrieving the minimum
 * value in constant time. This is implemented using SINGLE ARRAY.
 * For example, we populate our stack with [5, 2, 10, 1] (from left to right).
 */
public class TwoStacks {
    private final int[] stack;
    private int top1;
    private int top2;
    private final int size;

    public TwoStacks(int capacity) {
        size = capacity;
        this.stack = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push1(int value) {
        if (top1 < top2 - 1)
            stack[++top1] = value;
        else
            throw new IllegalStateException("Stack1 is full!");
    }

    public void push2(int value) {
        if (top1 < top2 - 1)
            stack[--top2] = value;
        else
            throw new IllegalStateException("Stack2 is full!");
    }

    public int pop1() {
        if (top1 < 0)
            throw new IllegalStateException("Stack1 is empty");

        return stack[top1--];
    }

    public int pop2() {
        if (top2 > size)
            throw new IllegalStateException("Stack2 is full");

        return stack[top2++];
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == size;
    }

    public boolean isFull1() {
        return top1 >= top2 - 1;
    }

    public boolean isFull2() {
        return top1 >= top2 - 1;
    }
}
