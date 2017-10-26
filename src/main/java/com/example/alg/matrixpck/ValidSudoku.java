package com.example.alg.matrixpck;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /**
     * Determine if a Sudoku is valid. The Sudoku board could be partially filled,
     * where empty cells are filled with the character '.'.
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        Set<String> rows = new HashSet<>();
        Set<String> columns = new HashSet<>();
        Set<String> cubes = new HashSet<>();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if(number=='.')
                    continue;

                if (!rows.add(number + "Row" + i))
                    return false;

                if (!columns.add(number + "Column" + j))
                    return false;

                if (!cubes.add(number + "Cube" + i / 3 + "-" + j / 3))
                    return false;
            }
        }
        return true;
    }
}
