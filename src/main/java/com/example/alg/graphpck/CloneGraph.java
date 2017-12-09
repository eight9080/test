package com.example.alg.graphpck;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    /**
     * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        UndirectedGraphNode result = null;

        Map<Integer, UndirectedGraphNode> nodesByLabel = new HashMap<>();

        Deque<UndirectedGraphNode> toVisitNodes = new ArrayDeque<>();
        toVisitNodes.add(node);

        while (!toVisitNodes.isEmpty()) {

            final UndirectedGraphNode oldNode = toVisitNodes.poll();

            UndirectedGraphNode clone = nodesByLabel.computeIfAbsent(oldNode.label,
                    k -> new UndirectedGraphNode(oldNode.label));

            if (result == null) {
                    result = clone;
            }

            if (!oldNode.neighbors.isEmpty()) {
                for (UndirectedGraphNode neighbour : oldNode.neighbors) {
                    UndirectedGraphNode foundNeighbour = nodesByLabel.get(neighbour.label);
                    if (foundNeighbour == null) {
                        foundNeighbour = new UndirectedGraphNode(neighbour.label);
                        nodesByLabel.put(neighbour.label, foundNeighbour);
                        toVisitNodes.add(neighbour);
                    }
                    clone.neighbors.add(foundNeighbour);
                }
            }
        }

        return result;

    }
}
