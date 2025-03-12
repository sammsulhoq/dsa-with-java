package stacks;

import java.util.Stack;

public class ReverseString {
    public static String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException("Input string cannot be empty!");

        Stack<Character> charactersStack = new Stack<>();
        for(char c: input.toCharArray()) {
            charactersStack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while(!charactersStack.empty())
            reversed.append(charactersStack.pop());

        return reversed.toString();
    }
}
