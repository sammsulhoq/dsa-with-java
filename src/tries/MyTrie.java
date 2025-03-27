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

        public boolean hasChildren() { return !children.isEmpty(); }

        public void removeChild(char ch) { children.remove(ch); }
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

    public void remove(String word) {
        remove(root, word, 0);
    }

    /*
    * For traversing Trie pre-order traversal is used
    */
    private void traverse(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        for (Node node: root.getChildren())
            traverse(node);
    }

    /*
    * For removal use post-order traversal and set isEndOfWord = false
    */
    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }
}
