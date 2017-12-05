package com.example.alg.graphpck;

import java.util.ArrayDeque;
import java.util.Deque;

public class Search {

    public static boolean breathFirstSearch(GraphNode root, int x){

        if(root.val==x){
            return true;
        }

        Deque<GraphNode> queue = new ArrayDeque<>();
        root.visited=true;
        queue.offer(root);

        while (!queue.isEmpty()){
            final GraphNode node = queue.poll();
            for(GraphNode neighbour: node.neighbors){
                if(!neighbour.visited){
                    System.out.println("Elem "+neighbour.val);
                    neighbour.visited=true;
                    if(neighbour.val==x){
                        return true;
                    }
                    queue.offer(neighbour);
                }
            }
        }
        return false;
    }
}
