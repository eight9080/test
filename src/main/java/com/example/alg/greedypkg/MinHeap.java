package com.example.alg.greedypkg;

public class MinHeap {

    int capacity;
    int currentSize;
    PrimUsingMinHeap.HeapNode[] mH;
    int [] indexes; //will be used to decrease the key

    public MinHeap(int capacity) {
        this.capacity = capacity;
        mH = new PrimUsingMinHeap.HeapNode[capacity + 1];
        indexes = new int[capacity];
        mH[0] = new PrimUsingMinHeap.HeapNode();
        mH[0].key = Integer.MIN_VALUE;
        mH[0].vertex=-1;
        currentSize = 0;
    }


    public void insert(PrimUsingMinHeap.HeapNode heapNode) {
        currentSize++;
        mH[currentSize]=heapNode;
        indexes[heapNode.vertex]=currentSize;
        bubbleUp(currentSize);
    }

    public void bubbleUp(int position) {
        int parentIndex = position / 2;
        int currentIndex = position;

        while (currentIndex>0 && mH[currentIndex].key<mH[parentIndex].key){

            final PrimUsingMinHeap.HeapNode parentNode = mH[parentIndex];
            final PrimUsingMinHeap.HeapNode currentNode = mH[currentIndex];

            //swap

            indexes[currentNode.vertex] = parentIndex;
            indexes[parentNode.vertex] = currentIndex;

            swap(currentIndex, parentIndex);

            currentIndex= parentIndex;
            parentIndex=parentIndex/2;

        }

    }

    private void swap(int node1, int node2) {
        PrimUsingMinHeap.HeapNode temp = mH[node1];
        mH[node1] = mH[node2];
        mH[node2] = temp;
    }

    public boolean isEmpty() {
        return currentSize ==0;
    }

    public PrimUsingMinHeap.HeapNode extractMin() {

        final PrimUsingMinHeap.HeapNode minNode = mH[1];

        final PrimUsingMinHeap.HeapNode lastNode = mH[currentSize];
        //move the last node to teh top
        indexes[lastNode.vertex] = 1;
        mH[1]=lastNode;
        mH[currentSize] = null;
        sinkDown(1);
        currentSize--;
        return minNode;

    }

    private void sinkDown(int position) {

        int smallest = position;
        int leftChildIdx = 2*position;
        int rightChildIdx = 2*position+1;

        if(leftChildIdx<heapSize() && mH[smallest].key>mH[leftChildIdx].key){
            smallest = leftChildIdx;
        }
        if(rightChildIdx<heapSize() && mH[smallest].key>mH[rightChildIdx].key){
            smallest = rightChildIdx;
        }

        if(smallest!=position){
            final PrimUsingMinHeap.HeapNode next = mH[smallest];
            final PrimUsingMinHeap.HeapNode initialNode = mH[position];

            //swap
            indexes[next.vertex] = position;
            indexes[initialNode.vertex] = smallest;

            swap(smallest, position);

            sinkDown(smallest);

        }

    }

    private int heapSize() {
        return currentSize;
    }
}
