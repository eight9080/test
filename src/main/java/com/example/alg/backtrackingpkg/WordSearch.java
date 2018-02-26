package com.example.alg.backtrackingpkg;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class WordSearch {

    private static boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if(board==null || board.length==0 || word==null || word.length()==0){
            return false;
        }

        visited= new boolean[board.length][board[0].length];
        final char firstLetter = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(firstLetter==board[i][j]){
                    if(findWord(board, word, i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private boolean findWord(char[][] board, String word, int i, int j, int indexWord) {

        if(indexWord==word.length()){
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }

        if(board[i][j]!=word.charAt(indexWord) || visited[i][j]){
            return false;
        }

        visited[i][j]=true;

        if(findWord(board, word, i-1, j, indexWord+1) ||
                findWord(board, word, i+1, j, indexWord+1) ||
                findWord(board, word, i, j-1, indexWord+1) ||
                findWord(board, word, i, j+1, indexWord+1)
                ){
            return true;
        }

        visited[i][j]=false;
        return false;
    }

    public static Double multiply(Double a, Double b) {
        return a * b;
    }
}
