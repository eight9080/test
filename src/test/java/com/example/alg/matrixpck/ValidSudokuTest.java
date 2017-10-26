package com.example.alg.matrixpck;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidSudokuTest {
    @Test
    public void isValidSudoku() throws Exception {
        final ValidSudoku v = new ValidSudoku();
        char[][] input = {
                {'5', '3','.',  '.', '7', '.',  '.', '.', '.'},
                {'6', '.','.',  '1', '9', '5',  '.', '.', '.'},
                {'.', '9','8',  '.', '.', '.',  '.', '6', '.'},

                {'8', '.','.',  '.', '6', '.',  '.', '.', '3'},
                {'4', '.','.',  '8', '.', '3',  '.', '.', '1'},
                {'7', '.','.',  '.', '2', '.',  '.', '.', '6'},

                {'.', '6','.',  '.', '.', '.',  '2', '8', '.'},
                {'.', '.','.',  '4', '1', '9',  '.', '.', '5'},
                {'.', '.','.',  '.', '8', '.',  '.', '7', '9'}

        };
        assertTrue(v.isValidSudoku(input));

    }


    @Test
    public void isValidSudoku_invalid() throws Exception {
        final ValidSudoku v = new ValidSudoku();
        char[][] input = {
                    {'.','.','4','.','.','.','6','3','.'},
                    {'.','.','.','.','.','.','.','.','.'},
                    {'5','.','.','.','.','.','.','9','.'},

                    {'.','.','.','5','6','.','.','.','.'},
                    {'4','.','3','.','.','.','.','.','1'},
                    {'.','.','.','7','.','.','.','.','.'},

                    {'.','.','.','5','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.'},
                    {'.','.','.','.','.','.','.','.','.'}};
        assertFalse(v.isValidSudoku(input));

    }



}