package com.medium.implementTrie;

class TrieNode {
    private static final char MY_NULL = ' ';
    public char val;
    public boolean flag = false;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
        this.val = MY_NULL;
    }

    public TrieNode(char c) {
        TrieNode tn = new TrieNode();
        tn.val = c;
    }
}

public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));  // returns true

        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));   // returns true

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] != null) {

            } else {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.flag = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
            } else {
                return false;
            }
        }
        return cur.flag;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}
