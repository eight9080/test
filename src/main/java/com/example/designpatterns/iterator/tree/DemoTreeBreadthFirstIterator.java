package com.example.designpatterns.iterator.tree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class DemoTreeBreadthFirstIterator<T> implements Iterator<T> {
    private final DemoTree<T> tree;
    private DemoTree<T> current;
    private Queue<DemoTree<T>> queue = new ArrayDeque<>();
    private int countNodes;


    public DemoTreeBreadthFirstIterator(DemoTree<T> ts) {
        this.tree = ts;

    }

    @Override
    public boolean hasNext() {
        if(countNodes==0 && tree.getSize()!=0){
            return true;
        }
        if(countNodes>=tree.getSize()){
            return false;
        }
        if(!queue.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if(current==null){
            current = tree;
            addChildren(current);
            countNodes++;
            return current.getValue();
        }
        while (!queue.isEmpty()){
            final DemoTree<T> node = queue.poll();
            addChildren(node);
            current = node;
            countNodes++;
            return current.getValue();
        }

        return null;
    }

    private void addChildren(DemoTree<T> node){
        if(node.getLeftChild()!=null) {
            queue.offer(node.getLeftChild());
        }
        if(node.getRightChild()!=null) {
            queue.offer(node.getRightChild());
        }
    }
}
