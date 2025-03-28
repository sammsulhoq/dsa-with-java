package tries;

public class Basic {
    public static void main(String[] args) {
        MyTrie trie = new MyTrie();
        trie.insert("cat");
        trie.insert("bat");
        trie.insert("bag");
        System.out.println(trie.contains("bata"));

        trie.traverse();

        trie.remove("cat");

        trie.traverse();

        // Testing autocomplete
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");

        System.out.println(trie.findWords("car"));
        System.out.println(trie.findWords("care"));
    }
}
