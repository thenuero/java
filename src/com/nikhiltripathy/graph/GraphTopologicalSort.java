package com.nikhiltripathy.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphTopologicalSort {

    public static void main(String[] args) {

        int v = 6;
        int[][] edges = {{2, 3}, {3, 1}, {4, 0},
                {4, 1}, {5, 0}, {5, 2}};


        List<Integer>[] adjList = constructAdjList(edges, v);

        //Graph constructed. Neighbors are 'dependencies' which need resolution before vertex can be marked processed.

        List<Integer> answer = topologicalSort(adjList, v);
        answer.forEach(System.out::println);
    }

    @SuppressWarnings("unchecked")
    static List<Integer>[] constructAdjList(int[][] edges, int vertices) {
        List<Integer>[] adjList = new ArrayList[vertices];

        for (int i=0;i<vertices;i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            adjList[edge[0]].add(edge[1]);
        }

        return adjList;
    }

    static List<Integer> topologicalSort(List<Integer>[] adjList, int vertices) {

        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i<vertices;i++) {
            if (!visited[i]) {
                topologicalSortRoutine(i, adjList, visited, stack);
            }
        }
        while(!stack.isEmpty()) {
            answer.add(stack.pop());
        }
        return answer;
    }

    static void topologicalSortRoutine(int vertex, List<Integer>[] adj, boolean[] visited, Stack<Integer> stack) {

        visited[vertex] = true;

        for (int i: adj[vertex]) {
            if(!visited[i]) {
                topologicalSortRoutine(i, adj, visited, stack);
            }
        }

        stack.push(vertex);
    }
}
