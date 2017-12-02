package com.example.alg.triepkg;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        HashMap<Character, TrieNode> children = root.children;

        for(int i = 0; i< word.length(); i++){
            final char character = word.charAt(i);
            TrieNode chNode = null;
            if(children.containsKey(character)){
                chNode=children.get(character);
            }else {
                chNode = new TrieNode(character);
                children.put(character, chNode);
            }

            if(i==word.length()-1){
                chNode.isLeaf=true;
            }

            children=chNode.children;

        }


    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        final TrieNode foundNode = searchNode(word);
        return foundNode != null && foundNode.isLeaf;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        final TrieNode foundNode = searchNode(prefix);
        return foundNode != null;
    }

    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children;
        TrieNode chNode = null;
        for(int i=0; i<str.length(); i++){
            char character = str.charAt(i);
            if(children.containsKey(character)){
                chNode = children.get(character);
                children = chNode.children;
            }else{
                return null;
            }
        }

        return chNode;
    }

}
