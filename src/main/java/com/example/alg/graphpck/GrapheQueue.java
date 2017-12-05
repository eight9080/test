package com.example.alg.graphpck;

public class GrapheQueue {

    GraphNode first, last;

    public void enqueue(GraphNode n){

        GraphNode temp = last;
        temp.next=n;
        last=n;

        if(first==null){
            first=last;
        }

    }

    public GraphNode dequeue(){
        if(first==null){
            return null;
        }
        GraphNode result = new GraphNode(first.val, first.neighbors);
        first=first.next;
        return result;

    }
}
