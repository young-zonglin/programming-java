package yzl.leetcode;

public class Solution_208_实现Trie前缀树 {
    public static void main(String[] args) {
        new Trie();
    }
}

class Trie {
    static class TrieNode {
        boolean isEnd;
        TrieNode[] nexts;

        public TrieNode() {
            isEnd = false;
            nexts = new TrieNode[26];
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode travel = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            int index = cur - 'a';
            if (travel.nexts[index] == null) {
                travel.nexts[index] = new TrieNode();
            }
            travel = travel.nexts[index];
        }
        travel.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode travel = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (travel.nexts[index] == null) {
                return false;
            }
            travel = travel.nexts[index];
        }
        return travel.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode travel = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (travel.nexts[index] == null) {
                return false;
            }
            travel = travel.nexts[index];
        }
        return true;
    }
}