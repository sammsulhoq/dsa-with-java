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

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }
    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (char ch: word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String searchTerm) {
        if (searchTerm == null)
            return false;

        var current = root;
        for (char ch: searchTerm.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }

            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        for (Node node: root.getChildren())
            traverse(node);
    }
}
