package stacks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class LinkedListAsStack {
    private final LinkedList<Integer> stack;
    private int head;

    public LinkedListAsStack() {
        stack = new LinkedList<>();
        head = 0;
    }

    public void push(int value) {
        stack.add(value);
        head++;
    }

    public int pop() {
        if (head < 0 )
            throw new IllegalStateException();

        head--;
        return stack.removeLast();
    }

    public int peek() {
        return stack.getLast();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
