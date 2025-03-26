package tries;

import java.util.HashMap;
import java.util.HashSet;

public class MyTrie {
    public static byte ALPHABET_SIZE = 26;
    private class Node {
        private char value;
        private HashMap<Character, Node> children;
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
            children = new HashMap<>();
            isEndOfWord = false;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (char ch: word.toCharArray()) {
            if (current.children.get(ch) == null) {
                current.children.put(ch, new Node(ch));
            }
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }
}
