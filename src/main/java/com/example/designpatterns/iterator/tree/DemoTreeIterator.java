package com.example.designpatterns.iterator.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DemoTreeIterator<T> implements Iterator<T> {
    private final DemoTree<T> tree;
    private DemoTree<T> current;
    private DemoTree<T> previous;
    private Deque<DemoTree<T>> breadcrumb = new ArrayDeque<>();
    private int countNodes;

    public DemoTreeIterator(DemoTree<T> ts) {
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
        if (current != null) {
            if (current.getLeftChild() != null) {
                return true;
            }
            if (current.getRightChild() != null) {
                return true;
            }
            if (!breadcrumb.isEmpty()) {
                return true;
            }

        }
        return false;
    }

    @Override
    public T next() {
        if (current == null) {
            current = tree;
            countNodes++;
            return current.getValue();
        }
        if (current != null) {
            if (current.getLeftChild() != null) {
                breadcrumb.addFirst(current);
                current = current.getLeftChild();
                countNodes++;
                return current.getValue();
            }
            if (current.getRightChild() != null) {
                breadcrumb.addFirst(current);
                current = current.getRightChild();
                countNodes++;
                return current.getValue();
            }
            if (!breadcrumb.isEmpty()) {
                previous = current;
                while (true) {
                    current = breadcrumb.pollFirst();
                    if (previous != current.getRightChild()) {
                        break;
                    }
                }
                if (current.getRightChild() != null) {
                    breadcrumb.addFirst(current);
                    current = current.getRightChild();
                    countNodes++;
                    return current.getValue();
                }
            }

        }
        return null;
    }
}