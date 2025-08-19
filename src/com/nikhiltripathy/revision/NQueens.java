package com.nikhiltripathy.revision;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> board = new ArrayList<>();

        boolean[] rows = new boolean[n+1];
        boolean[] rightDiagonal = new boolean[2* n +1];
        boolean[] leftDiagonal = new boolean[2* n +1];

        nQueensSolver(1, n, res, board, rows, rightDiagonal, leftDiagonal);
        return res;
    }

    private static void nQueensSolver(int col, int n, List<List<Integer>> res, List<Integer> board, boolean[] rows, boolean[] rightDiagonal, boolean[] leftDiagonal) {
         if(col > n) {
             res.add(new ArrayList<>(board));
             return;
         }

         for (int row = 1; row <=n; row++) {
             if (!rows[row] && !leftDiagonal[row + col] && !rightDiagonal[n + row - col]) { // placement safe.

                 board.add(row);
                 rows[row] = leftDiagonal[row + col] = rightDiagonal [n + row - col] = true;

                 nQueensSolver(col+1, n, res, board, rows, rightDiagonal, leftDiagonal);

                 //else backtrack
                 rows[row] = leftDiagonal[row + col] = rightDiagonal [n + row - col] = false;
                 board.removeLast();

             }
         }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> lists = nQueens(n);
        lists.forEach(System.out::println);
    }
}
