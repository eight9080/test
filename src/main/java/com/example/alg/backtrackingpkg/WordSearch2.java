package com.example.alg.backtrackingpkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordSearch2 {
    /**
     * Given a 2D board and a list of words from the dictionary, find all words in the board.

     Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

     For example,
     Given words = ["oath","pea","eat","rain"] and board =

     [
     ['o','a','a','n'],
     ['e','t','a','e'],
     ['i','h','k','r'],
     ['i','f','l','v']
     ]
     Return ["eat","oath"].

     Solution
     Intuitively, start from every cell and try to build a word in the dictionary. Backtracking (dfs) is the powerful way to exhaust every possible ways. Apparently, we need to do pruning when current character is not in any word.
     TrieNode is all we need. search and startsWith are useless.
     No need to store character at TrieNode. c.next[i] != null is enough.
     */
    public List<String> findWords(char[][] board, String[] words) {
        if(board==null || words==null || words.length==0){
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        final TrieElement trieWrods = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsFindWords(board, trieWrods, i, j, result);
            }
        }
        
        return result;
    }

    private void dfsFindWords(char[][] board, TrieElement trieWords, int i, int j, List<String> result) {

        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return;
        }

        final char character = board[i][j];
        //if already visited
        if(character=='*'){
            return;
        }
        //if no word with that character
        final TrieElement childLetter = trieWords.children[character - 'a'];
        if(childLetter ==null){
            return;
        }

        trieWords=childLetter;
        if(trieWords.word!=null){
            result.add(trieWords.word);
            trieWords.word=null;
        }

        board[i][j]='*';

        if(i>0){
            dfsFindWords(board, trieWords,i-1, j, result);
        }
        if(j > 0){
            dfsFindWords(board, trieWords,i, j-1, result);
        }
        if(i< board.length-1) {
            dfsFindWords(board, trieWords,i+1, j, result);
        }
        if(j<board[0].length-1){
            dfsFindWords(board, trieWords,i, j+1, result);
        }

        board[i][j]=character;
    }

    private TrieElement buildTrie(String[] words) {
        TrieElement root = new TrieElement();

        for (String word : words) {

            TrieElement current = root;
            for (char c : word.toCharArray()) {
                final int letterIndex = c - 'a';
                TrieElement childLetter = current.children[letterIndex];
                if(childLetter==null){
                    childLetter= new TrieElement();
                    current.children[letterIndex] = childLetter;
                }
                current = childLetter;
            }
            current.word = word;
        }
        return root;
    }


    private static class TrieElement {
        String word;
        TrieElement[] children = new TrieElement[26];
    }
}
