package com.example.alg.graphpck.route;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RouteBetweenNodesTest {

    @Test
    public void search() {
        final Graph graph = getGraph();

        final RouteBetweenNodes r = new RouteBetweenNodes();

        final boolean search = r.search(graph, new Node(1), new Node(5));
        assertTrue(search);
    }

    @Test
    public void searchNotFound() {
        final Graph graph = getGraph();

        final RouteBetweenNodes r = new RouteBetweenNodes();

        final boolean search = r.search(graph, new Node(2), new Node(5));
        assertFalse(search);
    }

    private Graph getGraph() {
        final Node node4 = new Node(4);
        final Node node2 = new Node(2);
        final Node node1 = new Node(1);
        final Node node3 = new Node(3);
        final Node node6 = new Node(6);
        final Node node5 = new Node(5);

        node1.addAjacentNode(node2);
        node1.addAjacentNode(node3);
        node1.addAjacentNode(node6);

        node2.addAjacentNode(node4);

        node3.addAjacentNode(node5);

        return new Graph(Arrays.asList(node1, node2, node3, node4, node5, node6));
    }
}