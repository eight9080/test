package com.example.designpatterns.iterator.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoTree<T> implements Iterable<T>{

    private T value;
    private DemoTree<T> leftChild;
    private DemoTree<T> rightChild;
    private int size;

    private boolean useBreadthFirstIterator;

    public DemoTree(T value) {
        this.value = value;
        size++;
    }

    public DemoTree() {

    }

    public void add(T value){
        if(leftChild==null){
            this.leftChild = new DemoTree<T>(value);
        }else
        if(rightChild==null){
            this.rightChild = new DemoTree<T>(value);
        }else
        if(leftChild.depth() <= rightChild.depth()){
            leftChild.add(value);
        }else {
            rightChild.add(value);
        }
        size++;
    }

    public List<T> toList(){
        final ArrayList<T> result = new ArrayList<>();
        result.add(value);
        if(leftChild!=null){
            result.addAll(leftChild.toList());
        }
        if(rightChild!=null){
            result.addAll(rightChild.toList());
        }
        return result;
    }

    private int depth() {
        if(leftChild==null || rightChild == null){
            return 0;
        }
        return 1+ Math.max(leftChild.depth(), rightChild.depth());
    }


    @Override
    public Iterator<T> iterator() {
        if(useBreadthFirstIterator){
            return new DemoTreeBreadthFirstIterator<T>(this);
        }

        return new DemoTreeIterator<T>(this);
    }


    public T getValue() {
        return value;
    }

    public DemoTree<T> getLeftChild() {
        return leftChild;
    }

    public DemoTree<T> getRightChild() {
        return rightChild;
    }

    public List<DemoTree<T>> getChildren(){
        final ArrayList<DemoTree<T>> children = new ArrayList<>();
        if(getLeftChild()!=null){
            children.add(getLeftChild());
        }
        if(getRightChild()!=null){
            children.add(getRightChild());
        }
        return children;
    }

    public boolean isUseBreadthFirstIterator() {
        return useBreadthFirstIterator;
    }

    public void setUseBreadthFirstIterator(boolean useBreadthFirstIterator) {
        this.useBreadthFirstIterator = useBreadthFirstIterator;
    }

    public int getSize() {
        return size;
    }
}
