package stacks;

import java.util.Stack;

public class Expression {
    private final String input;

    public Expression(String input) {
        this.input = input;
    }

    public boolean isBalanced() {
        Stack<Character> characterStack = new Stack<>();

        for (char c: input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '<')
                characterStack.push(c);
            else if ((c == ')' && !characterStack.empty() && characterStack.peek() == '(')
                    || (c == ']' && !characterStack.empty() &&  characterStack.peek() == '[')
                    || (c == '}' && !characterStack.empty() &&  characterStack.peek() == '{')
                    || (c == '>' && !characterStack.empty() &&  characterStack.peek() == '<'))
                characterStack.pop();
        }

        return characterStack.empty();
    }
}
