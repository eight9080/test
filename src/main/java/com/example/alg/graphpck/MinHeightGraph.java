package com.example.alg.graphpck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinHeightGraph {
    /**
     * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
     * <p>
     * Format
     * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
     * <p>
     * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
     * <p>
     * Example 1:
     * <p>
     * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
     * <p>
     * 0
     * |
     * 1
     * / \
     * 2   3
     * return [1]
     * <p>
     * Example 2:
     * <p>
     * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     * <p>
     * 0  1  2
     * \ | /
     * 3
     * |
     * 4
     * |
     * 5
     * return [3, 4]
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add(0);
            return result;
        }

        List<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        if (leaves.size() == 1) {
            return new ArrayList<>();
        }

        int size = n;
        while (size > 2) {
            size= size-leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leave : leaves) {
                final Integer neighbour = graph.get(leave).iterator().next();
                graph.get(neighbour).remove(leave);
                if(graph.get(neighbour).size()==1){
                    newLeaves.add(neighbour);
                }
            }
            leaves=newLeaves;
        }
        return leaves;
    }
}
