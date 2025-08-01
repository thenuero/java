package com.nikhiltripathy.revision;

import java.util.ArrayList;
import java.util.List;

public class GraphDFS {

    public static void main(String[] args) {

        int v = 6;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};
        List<Integer>[] adjList = contructAdjList(edges, v);

       // displayAdjList(adjList);
        boolean[] visited = new boolean[v];
        List<Integer> answer = new ArrayList<>();
        dfs(adjList, 0, visited, answer); // not 4 and 5 remain unvisited if we start form 0.

        answer.forEach(System.out::println);
        for (boolean vis : visited) {
            System.out.println(vis);
        }

    }

    @SuppressWarnings("unchecked")
    private static List<Integer>[] contructAdjList(int[][] edges, int verticesCount) {
        List<Integer>[] adj = new ArrayList[verticesCount];

        for (int i=0;i<verticesCount; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]); // edge[0] -- vertex , edge[1] neighbor
        }

        return adj;
    }

    static void displayAdjList (List<Integer>[] adj) {
        for (int i=0;i<adj.length;i++) {
            System.out.print(i + ":");
            for (int neighbor : adj[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    static void dfs(List<Integer>[] adjList, int startNode, boolean[] visited, List<Integer> answer) {

        if (!visited[startNode]) {
            answer.add(startNode);
            visited[startNode] = true;
        }

        for (int neighbor : adjList[startNode]) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, visited, answer);
            }
        }
    }
}
