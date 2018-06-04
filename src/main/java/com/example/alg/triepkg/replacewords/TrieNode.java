package com.example.alg.triepkg.replacewords;


public class TrieNode {

    char value;
    TrieNode[] children;
    boolean isWord;

    public TrieNode(char val) {
        this.value = val;
        this.children = new TrieNode[26];
        this.isWord = false;
    }

}
