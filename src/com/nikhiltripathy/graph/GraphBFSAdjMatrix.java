package com.nikhiltripathy.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFSAdjMatrix {

    static int[][] mat;
    static int numberOfNode = 5;

    public static void main(String[] args) {
        mat = new int[numberOfNode][numberOfNode];

        addEdge(0,1);
        addEdge(0,2);
        addEdge(0,3);
        addEdge(0,4);

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numberOfNode];

        queue.add(0);

        bfs(queue, ans, visited);

        ans.forEach(System.out::println);

    }
    private static void addEdge(int x, int y) {
        mat[x][y] = 1;
        mat[y][x] = 1;
    }

    private static void bfs (Queue<Integer> queue, List<Integer> answer, boolean[] visited) {

        while(!queue.isEmpty()) {
            int ele = queue.poll();
            visited[ele] = true;
            answer.add(ele);
            for (int i=0;i<mat[ele].length;i++) {
                if (mat[ele][i] == 1 && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
    }
}
