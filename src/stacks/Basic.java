package stacks;

import java.util.Stack;

public class Basic {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(20);
        stack.add(30);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);

        // Reverse a string using Stack
        String input = "Sammsul Hoque Choudhary";
        System.out.println(ReverseString.reverse(input));

        // Checking balanced string
        input = "((a + b) * [c + d)";
        Expression expression = new Expression(input);
        System.out.println(expression.isBalanced());

        // Checking implementation for Stack with array
        ArrayAsStack arrayStack = new ArrayAsStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack);
        System.out.println(arrayStack.peek());

        // Checking implementation for Stack with linked list
        LinkedListAsStack llStack = new LinkedListAsStack();
        llStack.push(9);
        llStack.push(8);
        llStack.push(7);
        System.out.println(llStack);
        System.out.println(llStack.peek());
        System.out.println(llStack.pop());
        System.out.println(llStack);

        // Checking implementation of two stack
        TwoStacks stacks = new TwoStacks(10);
        stacks.push1(5);
        stacks.push1(10);
        stacks.push2(15);
        stacks.push2(20);

        System.out.println("Popped from Stack1: " + stacks.pop1()); // 10
        System.out.println("Popped from Stack2: " + stacks.pop2()); // 20
    }
}
