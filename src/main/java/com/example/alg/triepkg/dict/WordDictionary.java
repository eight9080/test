package com.example.alg.triepkg.dict;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
public class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i< word.length(); i++) {
            final char character = word.charAt(i);
            TrieNode node;

            if(children.containsKey(character)){
                node = children.get(character);
            }else {
                node=new TrieNode(character);
                children.put(character, node);
            }
            if(i==word.length()-1){
                node.isLeaf=true;
            }
            children=node.children;
        }

    }

    /** Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchDFS(word, 0, root.children);
    }

    private boolean searchDFS(String word, int index, Map<Character, TrieNode> children){
        final boolean isLastLetter = index == word.length();
        if(isLastLetter){
            return children.isEmpty();
        }

        final char character = word.charAt(index);

        final boolean isPenultimateLetter = index == word.length()-1;

        if(children.containsKey(character)){
            //is last letter
            final TrieNode node = children.get(character);
            if(isPenultimateLetter && node.isLeaf){
                return true;
            }

            return searchDFS(word, index+1, node.children);
        }else{
            if(character=='.'){
                boolean result = false;
                for(Map.Entry<Character, TrieNode> child: children.entrySet()){
                    if(isPenultimateLetter && child.getValue().isLeaf){
                        return true;
                    }
                    boolean found = searchDFS(word, index + 1, child.getValue().children);
                    if(found){
                        result=true;
                    }
                }
            return result;
            }

        }

        return false;

    }





}
