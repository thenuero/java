package com.nikhiltripathy.revision;

import java.util.ArrayList;
import java.util.List;

public class NQueensBruteForce {

    private static List<List<Integer>> nQueens(int n) {

        List<Integer> board = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        nQueensSolver(1, n, board, res, visited);
        return res;
    }

    private static void nQueensSolver(int col, int n, List<Integer> board, List<List<Integer>> res, boolean[] visited) {

        if (col > n) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int row = 1; row <= n; row++) {
            if (!visited[row]) {
                if(canPlace(board, row, col)) {
                    board.add(row);
                    visited[row] = true;

                    nQueensSolver(col+1, n, board, res, visited);

                    //backtrack
                    board.removeLast();
                    visited[row] = false;
                }
            }
        }
    }

    private static boolean canPlace(List<Integer> board, int currRow, int currCol) {
        //this loop can be optimised.
        for (int i=0;i<board.size();i++) {
            int placedCol = i+1;
            int placedRow = board.get(i);

            if (Math.abs(currRow - placedRow) == Math.abs(currCol - placedCol))
                return false;
        }
        return true;
    }

    public static void main(String... args) {
        int n =4;
        List<List<Integer>> lists = nQueens(n);
        lists.forEach(System.out::println);
    }
}
