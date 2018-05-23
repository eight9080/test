package com.example.alg.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


/**
 * From http://www.baeldung.com/java-dijkstra
 */
public class Dijkstra {

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unSettledNodes = new HashSet<>();

        unSettledNodes.add(source);

        while (!unSettledNodes.isEmpty()) {

            Node currentNode = getLowestDistanceNode(unSettledNodes);
            unSettledNodes.remove(currentNode);

            final Set<Map.Entry<Node, Integer>> entries = currentNode.getAdjacentNodes().entrySet();
            for (Map.Entry<Node, Integer> adjacencyPair : entries) {
                final Node adjacentNode = adjacencyPair.getKey();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, adjacencyPair.getValue(), currentNode);
                    unSettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }

        return graph;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {

        final Integer sourceNodeDistance = sourceNode.getDistance();
        final int currentDistance = sourceNodeDistance + edgeWeight;
        if (currentDistance < evaluationNode.getDistance()) {
            evaluationNode.setDistance(currentDistance);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> unSettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node : unSettledNodes) {
            final Integer distance = node.getDistance();
            if (lowestDistance > distance) {
                lowestDistanceNode = node;
                lowestDistance = distance;
            }
        }

        return lowestDistanceNode;
    }
}
