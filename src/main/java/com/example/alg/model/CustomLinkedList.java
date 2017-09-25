package com.example.alg.model;

import java.util.List;

public class CustomLinkedList {

    private Node head;
    private Node tail;

    public CustomLinkedList(){
        this.head = new Node("head");
        this.tail = this.head;
    }

    public Node getHead(){
        return this.head;
    }

    public void add(Node node){
        this.tail.next = node;
        this.tail = node;
    }

    public void addAll(List<String> dataList){
        dataList.forEach(data -> add(new Node(data)));
    }

    public String getLastNode(int n){
        Node fast = head;
        Node slow = head;
        int start = 1;
        while (fast.getNext()!=null){
            fast = fast.getNext();
            start++;
            if(start>n){
                slow = slow.getNext();
            }
        }
        return slow.getData();
    }


    public static class Node{
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    " data='" + data +
                  //  ", next=" + next +'\'' +

                    '}';
        }
    }

}
