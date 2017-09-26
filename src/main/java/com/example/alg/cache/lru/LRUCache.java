package com.example.alg.cache.lru;

import java.util.HashMap;

public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head=null;
    Node end=null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int value){
        if(map.containsKey(key)){
            final Node node = map.get(key);
            node.setValue(value);
            removeNode(node);
            setHead(node);
        }else{
            final Node nodeData = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.getKey());
                removeNode(end);
            }
            setHead(nodeData);
            map.put(key, nodeData);
        }
    }

    /**
     * Get from cache
     * @param key to search in cache
     * @return -1 - not found key
     */
    public int get(int key){
        if(!map.containsKey(key)){
            return  -1;
        }
        final Node node = map.get(key);
        removeNode(node);
        setHead(node);

        return node.getValue();
    }

    private void setHead(Node node) {
        node.setPre(null);
        node.setNext(head);

        if(head!=null){
           head.setPre(node);
        }
        head = node;

        if(end==null){
            end = head;
        }
    }


    private void removeNode(Node n){
        if(n.pre()==null){
            head = n.next();
        }else {
            n.pre().setNext(n.next());
        }
        if(n.next()!=null){
            n.next().setPre(n.pre());
        }else{
            end = n.pre();
        }
    }



}
