package com.nikhiltripathy.graph;

import java.util.*;

public class GraphTraversalBFS {

    private static List<Integer> bfs(List<List<Integer>> adjList, int startNode) {
        Queue<Integer> queue = new LinkedList<>(); // store elements for bfs
        List<Integer> answer = new ArrayList<>(); // stores answer
        queue.add(startNode);

        while(!queue.isEmpty()) {
            Integer current = queue.poll();
            if (!answer.contains(current)){
                answer.add(current);

                queue.addAll(adjList.get(current));
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));

        List<Integer> bfs = bfs(adj, 0);

        bfs.forEach(GraphTraversalBFS::printAns);
    }

    static void printAns(Integer integer) {
        System.out.print(integer + " ");
    }

}
