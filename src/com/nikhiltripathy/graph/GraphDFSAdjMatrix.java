package com.nikhiltripathy.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphDFSAdjMatrix {

    static int[][] mat;
    static int numberOfNode = 5;
    public static void main(String[] args) {

        mat = new int[numberOfNode][numberOfNode];

        addEdge(0,1);
        addEdge(0,2);
        addEdge(0,3);
        addEdge(0,4);

        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[numberOfNode];
        dfs(0, visited, ans);

        ans.forEach(System.out::print);
    }

    private static void addEdge(int x, int y) {
        mat[x][y] = 1;
        mat[y][x] = 1;
    }

    private static void dfs(int startNode, boolean[] visited, List<Integer> answer) {

        answer.add(startNode);
        visited[startNode] = true;

        for (int i=0;i<mat[startNode].length;i++) {
            //if the is an edge between startNode and i and it's not visited, do dfs.
            if (mat[startNode][i] == 1 && !visited[i])  {
                dfs(i, visited, answer);
            }
        }
    }
}
