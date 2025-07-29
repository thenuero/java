package com.nikhiltripathy.leetcode.graph;


import java.util.ArrayList;
import java.util.List;

//Adjacency list representation of directed graph.
public class AdjacencyList {

    public static void main(String[] args) {

        int v = 3; // 3 vertices and 3 edges.

        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0;i<v;i++) {
            adj.add(new ArrayList<>());
        }
        //add edges. for image refer https://www.geeksforgeeks.org/dsa/adjacency-list-meaning-definition-in-dsa/
        addEdge(adj, 1, 0);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);

        displayAdjList(adj);
    }

    private static void addEdge(List<List<Integer>> adj, int p, int q) {
        adj.get(p).add(q);
    }

    private static void displayAdjList(List<List<Integer>> adj) {
        int size = adj.size();

        for (int i=0;i<size;i++) {
            System.out.print(i + ": ");
            List<Integer> integers = adj.get(i);
            for (int integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
 }
