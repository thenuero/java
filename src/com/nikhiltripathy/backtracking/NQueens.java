package com.nikhiltripathy.backtracking;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

//Time complexity -- O(n!)
//Space complexity -- O(n)
public class NQueens {
    //Solving N queens using backtracking
    private static List<List<Integer>> nQueenSolve(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> board = new ArrayList<>();

        //Rows occupied
        boolean[] rows = new boolean[n + 1];
        //Represents number of parallel diagonals. Completely mathematics.
        //Number of Diagonals, 2n-1. n is the size of chessboard.
        //Boolean representation of diagonals engaged.
        boolean[] majorDia = new boolean[2 * n + 1];
        boolean[] minorDia = new boolean[2 * n + 1];

        nQueenRecur(1, n, board, res, rows, majorDia, minorDia);
        return res;
    }

    private static void nQueenRecur(int col, int n, List<Integer> board, List<List<Integer>> res, boolean[] rows, boolean[] majorDia, boolean[] minorDia) {
        //base case of recursion
        if (col > n) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int i = 1; i <= n; i++) { //iterate through all rows.
            if (!rows[i] && !majorDia[i + col] && !minorDia[n + i - col]) { //this means all attacking positions of queen are clear.

                //place queen
                rows[i] = majorDia[i + col] = minorDia[n + i - col] = true;
                board.add(i);

                nQueenRecur(col + 1, n, board, res, rows, majorDia, minorDia);

                //Remove queen (backtrack).
                rows[i] = majorDia[i + col] = minorDia[n + i - col] = false;
                board.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Instant start = Instant.now();
        List<List<Integer>> res = nQueenSolve(n);
        Instant end = Instant.now();
        System.out.println("Total execution time " + Duration.between(start, end).toMillis() + "ms");
        res.forEach(System.out::println);
    }
}
