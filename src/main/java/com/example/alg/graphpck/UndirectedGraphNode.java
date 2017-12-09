package com.example.alg.graphpck;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UndirectedGraphNode that = (UndirectedGraphNode) o;
        final boolean b = label == that.label;
        if(neighbors==that.neighbors && b){
            return true;
        }

        if(neighbors==null && that.neighbors!=null){
            return false;
        }

        final String path1 = traverse(this);
        final String path2 = traverse(that);



        return b && path1.equals(path2);


    }

    private String traverse(UndirectedGraphNode node){
        StringBuilder temp = new StringBuilder();

        Set<Integer> visited = new HashSet<>();

        Deque<UndirectedGraphNode> toVisitNodes = new ArrayDeque<>();
        toVisitNodes.add(node);

        while (!toVisitNodes.isEmpty()) {
            final UndirectedGraphNode n = toVisitNodes.poll();
            visited.add(n.label);
            temp.append(n.label);
            for(UndirectedGraphNode neighbour: n.neighbors){
                temp.append(",").append(neighbour.label);
                if(!visited.contains(neighbour.label)) {
                    toVisitNodes.add(neighbour);
                }
            }
            temp.append("#");
        }
        temp.deleteCharAt(temp.length()-1);
        return temp.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, neighbors);
    }

    @Override
    public String toString() {
        return "UndirectedGraphNode{" +
                "label=" + label +
                ", neighbors=" + neighbors.stream()
                                            .map(n-> String.valueOf(n.label))
                                            .collect(joining(",")) +
                '}';
    }
}
