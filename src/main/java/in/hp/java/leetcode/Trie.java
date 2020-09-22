package in.hp.java.leetcode;

import java.util.HashMap;
import java.util.Map;

class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apps");
//        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
//        trie.insert("app");
//        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("apple"));
        System.out.println(trie.startsWith("apps"));
//        System.out.println(trie.startsWith("air"));
    }
}

class Trie {

    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(Node parent, String word, int index) {
        if (index == word.length())
            return;

        Node node = new Node();
        node.character = word.charAt(index);
        if (index == word.length() - 1)
            node.wordsEnding = 1;
        parent.children.put(word.charAt(index), node);

        insert(node, word, ++index);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node parent, String word, int index) {
        if (index == word.length() || parent.children.size() == 0)
            return false;

        boolean isLastChar = false;
        if (index == word.length() - 1)
            isLastChar = true;

        Node node = parent.children.get(word.charAt(index));

        if (node == null || (isLastChar && node.wordsEnding < 1))
            return false;
        else if (isLastChar && node.wordsEnding > 0)
            return true;
        else
            return search(node, word, ++index);

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(Node parent, String word, int index) {
        if (index == word.length() || parent.children.size() == 0)
            return false;

        boolean isLastChar = false;
        if (index == word.length() - 1)
            isLastChar = true;

        Node node = parent.children.get(word.charAt(index));

        if (node == null || node.children.size() < 1)
            return false;
        else if (isLastChar)
            return true;
        else
            return startsWith(node, word, ++index);
    }
}

class Node {
    Character character;
    Map<Character, Node> children;
    int wordsEnding;

    public Node() {
        children = new HashMap<>();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */