package com.nikhiltripathy.backtracking;

import java.util.Arrays;

//This is brute force approach, can be optimised using bitmasking will come to that later.
public class SodukoSolverBruteForce {
    static final int SODOKU_SIZE = 9;

    public static void main(String[] args) {
        int[][] sodoku = new int[][] {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        solveSodoku(sodoku,0, 0);

        Arrays.stream(sodoku)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    private static boolean solveSodoku(int[][] sodoku, int currRow, int currColumn) {
        //base case
        if (currRow == 8 && currColumn == 9) return true;

        if (currColumn == 9) {
            currRow++;
            currColumn = 0;
        }
        if (sodoku[currRow][currColumn] != 0) {
            return solveSodoku(sodoku, currRow, currColumn+1);
        }
        //check for the number that can be placed.

        for (int num=1;num<=9;num++) {
            if (isSafe(sodoku, currRow, currColumn, num)) {
                sodoku[currRow][currColumn] = num;
                if(solveSodoku(sodoku, currRow, currColumn+1)) {
                    return true;
                }
                sodoku[currRow][currColumn]= 0;
            }

        }
        return false;
    }

    private static boolean isSafe(int[][] matrix, int row, int column, int num) {

        //Check in the column
        for (int i=0;i<9;i++) {
            if (matrix[i][column] == num) {
                return false;
            }
        }

        //Check in the row.
        for (int j=0;j<9;j++) {
            if (matrix [row][j] == num) {
                return false;
            }
        }

        //Check in the 3x3 grid.
        int startRow = row - (row % 3);
        int startColumn = column - (column %3);

        for(int r = startRow; r < startRow + 3; r++) {
            for (int c= startColumn; c<startColumn + 3; c++) {
                if (matrix[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
