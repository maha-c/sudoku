package test;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        // Initialize Sudoku board
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        // Check whether the board is valid
        boolean isValid = isValidSudoku(board);
        System.out.println(isValid);
    }

    public static boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);
                }
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            Set<Character> col = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (col.contains(board[i][j])) {
                        return false;
                    }
                    col.add(board[i][j]);
                }
            }
        }

        // Check sub-boxes
        for (int k = 0; k < 9; k++) {
            Set<Character> box = new HashSet<>();
            for (int i = 3 * (k / 3); i < 3 * (k / 3) + 3; i++) {
                for (int j = 3 * (k % 3); j < 3 * (k % 3) + 3; j++) {
                    if (board[i][j] != '.') {
                        if (box.contains(board[i][j])) {
                            return false;
                        }
                        box.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}
