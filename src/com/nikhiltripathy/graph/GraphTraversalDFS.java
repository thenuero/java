package com.nikhiltripathy.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphTraversalDFS {

    public static void main(String[] args) {
        int v = 5;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0;i<v;i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = { { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } };

        for (int[] edge : edges) {
            addEdge(adj, edge[0], edge[1]);
        }

        List<Integer> answer = dfs(adj);

        answer.forEach(GraphTraversalBFS::printAns);
    }

    private static void addEdge (List<List<Integer>> adj, int to, int from) {
        adj.get(to).add(from);
        adj.get(from).add(to);
    }

    private static List<Integer> dfs(List<List<Integer>> adj) {

        boolean[] visited = new boolean[adj.size()];
        List<Integer> answer = new ArrayList<>();
        recDFS(adj, 0, visited, answer);
        return answer;
    }

    private static void recDFS(List<List<Integer>> adj, int startNode, boolean[] visited, List<Integer> answer) {
        //Start from start node, add to answer, mark as visited.
        //Recursive call to neighbor in order of addition

        if(!visited[startNode]) {
            answer.add(startNode);
            visited[startNode] = true;

            for (int i : adj.get(startNode)) {
                if (!visited[i]) {
                    recDFS(adj, i, visited, answer);
                }
            }
        }

    }
}
