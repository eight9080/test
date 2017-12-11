package com.example.alg.graphpck;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GraphValidTree {
    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), check if these edges form a valid tree.
     * This problem can be converted to finding a cycle in a graph. It can be solved by using DFS (Recursion) or BFS (Queue).
     */
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        IntStream.range(0, n).forEach(i-> map.put(i, new ArrayList<>()));

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (!dfs(0, -1, map, visited)){
            return false;
        }

        for(boolean b : visited){
            if(!b){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int current, int parent,
                        Map<Integer, ArrayList<Integer>> map, boolean[] visited) {
        if(visited[current]){
            return false;
        }
        visited[current]=true;
        final ArrayList<Integer> neighbours = map.get(current);
        for(int neighbour: neighbours){
            if(parent!=neighbour && !dfs(neighbour, current, map, visited)){
                return false;
            }
        }
        return true;
    }

    public boolean validTreeBFS(int n, int[][] edges) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        IntStream.range(0, n).forEach(i-> map.put(i, new ArrayList<>()));

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()){

            final Integer current = queue.poll();
            if(visited[current]){
                return false;
            }

            visited[current]=true;

            final ArrayList<Integer> neighbours = map.get(current);
            for(Integer neighbour: neighbours){
                if(!visited[neighbour]){
                    queue.offer(neighbour);
                }
            }
        }

        for(boolean b : visited){
            if(!b){
                return false;
            }
        }

        return true;

    }

}
