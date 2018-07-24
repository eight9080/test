package com.example.alg.graphpck.route;

import java.util.LinkedList;

public class RouteBetweenNodes {

    public boolean search(Graph graph, Node start, Node end){

        if(start.getValue()== end.getValue()){
            return true;
        }

        graph.getNodes()
                .forEach(node -> node.setState(Node.State.Unvisited));

        final Node startNodeFound = graph.getNodes().stream()
                .filter(node -> node.getValue() == start.getValue())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Start node does not exist"));

        startNodeFound.setState(Node.State.Visiting);

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(startNodeFound);

        while (!queue.isEmpty()){
            final Node node = queue.removeFirst();
            for (Node child: node.getAdjacent()) {
                if(child.getState()!= Node.State.Unvisited){
                    continue;
                }
                if(child.getValue()==end.getValue()){
                    return true;
                }else {
                    child.setState(Node.State.Visiting);
                    queue.add(child);
                }
            }
            node.setState(Node.State.Visited);
        }

        return false;


    }


}
