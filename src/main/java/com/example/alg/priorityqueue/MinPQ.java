package com.example.alg.priorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.System.out;

public class MinPQ<Key> implements Iterable<Key> {

    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator

    public MinPQ(int size) {
        pq = (Key[])new Object[size=1];
        n = 0;
    }

    public MinPQ() {
        this(1);
    }

    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        pq = (Key[])new Object[initCapacity=1];
        n = 0;
        this.comparator = comparator;
    }

    public MinPQ(Comparator<Key> comparator) {
     this(1, comparator);
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    private int size() {
        return n;
    }

    private boolean isEmpty() {
        return n==0;
    }

    private void insert(Key key) {
        if(n==pq.length-1){
            resize(2*pq.length);
        }
        
        pq[++n] = key;
        swim(n);
    }

    private Key delMin() {
        if(isEmpty()){
            throw new NoSuchElementException("Priority queue underflow");
        }
        exch(1,n);
        Key min = pq[n--];
        sink(1);
        pq[n+1] = null;         // avoid loitering and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length  / 2);
        assert isMinHeap();
        return min;
    }

    private void sink(int k) {
        while (2*k<=n){
            int j = 2*k;
            if(j<n && greater(j, j+1)) j++;
            if(!greater(k,j)) break;
            exch(k,j);
            k=j;
        }
    }

    // is pq[1..N] a min heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    private void resize(int capacity) {
        Key[] temp =(Key[])new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq=temp;
    }

    private void swim(int k) {
        while(k>1 && greater(k/2, k)){
            exch(k, k/2);
            k=k/2;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private boolean greater(int i, int j) {
        if(comparator==null){
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        return comparator.compare(pq[i], pq[j])>0;
    }


    private class HeapIterator implements Iterator<Key>{

        private MinPQ<Key> copy;

        public HeapIterator() {
            if(comparator ==null){
                copy = new MinPQ<>(size());
            }else {
                copy = new MinPQ<>(size(), comparator);
            }
            for (int i = 0; i < n; i++) {
                copy.insert(pq[i]);
            }

        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Key next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public static void main(String[] args) {
        MinPQ<String> queue = new MinPQ<>(Comparator.<String>reverseOrder());
        queue.insert("P");
        queue.insert("R");
        queue.insert("I");
        queue.insert("O");
        queue.insert("R");
        queue.insert("I");
        queue.insert("T");
        queue.insert("Y");
        queue.insert("Q");
        queue.insert("U");
        queue.insert("E");
        queue.insert("U");
        queue.insert("E");

        while (!queue.isEmpty()) {
            out.printf("%s ", queue.delMin());
        }
    }



}
