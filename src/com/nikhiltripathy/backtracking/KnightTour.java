package com.nikhiltripathy.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created on 24/08/2025 at 08:16
 * Author: theneuro
 * <a href="https://www.geeksforgeeks.org/dsa/the-knights-tour-problem/">...</a>
 */

public class KnightTour {
    //knights moves
    static final int[] deltaRow = new int[]{-2, -2, 2,2,1,-1,-1,-1};
    static final int[] deltaColumn = new int[]{1,-1,1,-1,2,2,-2,-2};
    public static void main(String[] args) {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter n");
        try {
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        int[][] board = new int[n][n];
        for (int[] row :board) {
            Arrays.fill(row, -1);
        }
        board[0][0] = 0;

        if(knightsTour(board, 0, 0, 1, n)) {
            for (int[] r : board) {
                for (int ele : r) {
                    System.out.print(ele + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean checkSafety (int row, int column, int[][] board) {
        int size = board.length;

        if (row >= size || row < 0 || column >=size || column < 0 || board[row][column] != -1) {
            return false;
        }
        return true;
    }

    private static boolean knightsTour(int[][] board, int row, int column, int step, int n) {

        if (step == n*n) {
            //all squares visited
            return true;
        }

        for (int i=0;i<8;i++) {
            int nextRow = row + deltaRow[i];
            int nextCol = column + deltaColumn[i];

            if(checkSafety(nextRow, nextCol, board)) {
                board[nextRow][nextCol] = step;

                if (knightsTour(board, nextRow, nextCol, step+1, n)) {
                    return true;
                }
                //backtrack
                board[nextRow][nextCol] = -1;
            }
        }
        return false;
    }
}
