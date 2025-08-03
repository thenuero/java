package com.nikhiltripathy.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphKahnAlgo {

    public static void main(String[] args) {

        int v = 6;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};

        int[] answer = topologicalSortKahnAlgo(edges, v);

        System.out.println("Topological sort of the graph: ");
        for (int ele : answer) {
            System.out.print(ele + " ");
        }
    }

    /*
        Add all nodes with in-degree 0 to a queue.
        While the queue is not empty:
        Remove a node from the queue.
        For each outgoing edge from the removed node, decrement the in-degree of the destination node by 1.
        If the in-degree of a destination node becomes 0, add it to the queue.
        If the queue is empty and there are still nodes in the graph, the graph contains a cycle and cannot be topologically sorted.
        The nodes in the queue represent the topological ordering of the graph.
     */

    private static int[] topologicalSortKahnAlgo(int[][] edges, int vertices) {
        int[] answer = new int[vertices];
        int index = 0;
        List<Integer>[] adj = constructAdjList(edges, vertices);
        int[] indegree = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();

        //Calculate the indegree of all nodes.
        for (int i=0;i<vertices;i++) {
            for(int neighbor : adj[i]) {
                indegree[neighbor]++;
            }
        }

        for (int i=0;i<vertices;i++) {
            if (indegree[i] == 0) { // indegree 0 means no dependency so ready to process.
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int ele = queue.poll();
            answer[index++] = ele;
            //decrease the indegree of neighbors
            for (int neighbor : adj[ele]) {
                indegree[neighbor] --;
                if (indegree[neighbor] == 0) { // all dependencies processed.
                    queue.add(neighbor);
                }
            }
        }

        if (index != vertices) {
            System.out.println("Graph contains cycle"); // couldn't process all nodes.
            return new int[0];
        }
        return answer;
    }

    private static List<Integer>[] constructAdjList(int[][] edges, int verticesCount) {
        List<Integer>[] adj = new ArrayList[verticesCount];

        for (int i=0;i<verticesCount;i++) {
            adj[i] = new ArrayList<>(); //to avoid NPE.
        }

        for (int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }
}
