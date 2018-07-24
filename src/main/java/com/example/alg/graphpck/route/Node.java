package com.example.alg.graphpck.route;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    enum State{
        Unvisited,
        Visited,
        Visiting
    }


    private int value;
    private State state;
    private List<Node> adjacent = new ArrayList<>();

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, List<Node> adjacent) {
        this.value = value;
        if(adjacent!=null) {
            this.adjacent.addAll(adjacent);
        }
    }


    public void addAjacentNode(Node node){
        this.adjacent.add(node);
    }


    public int getValue() {
        return value;
    }

    public List<Node> getAdjacent() {
        return adjacent;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                Objects.equals(adjacent, node.adjacent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, adjacent);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", adjacent=" + adjacent +
                '}';
    }
}
