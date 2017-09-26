package com.example.alg.cache.lru;

public class Node {

    private int key;
    private int value;
    private Node pre;
    private Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    public Node pre() {
        return pre;
    }

    public Node next() {
        return next;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value ;
    }
}
