package queues;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Queue data structure can be achieved using Stacks but in that case
 * we have to go for two stacks: One for "enqueue" and second one for
 * "dequeue"
 *
 * Q [10,20,30]
 * S1[]         // enqueue
 * S2[30,20,10]
 */
public class QueueWithTwoStacks {
    private Stack<Integer> stack1, stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return stack2.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        return stack2.stream().map(String::valueOf).reduce((a, b) -> a + ", " + b).orElse("");
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
    }
}
