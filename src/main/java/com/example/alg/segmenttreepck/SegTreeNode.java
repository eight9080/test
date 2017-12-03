package com.example.alg.segmenttreepck;

public class SegTreeNode {

    int start;
    int end;
    int sum;
    SegTreeNode leftChild;
    SegTreeNode rightChild;

    public SegTreeNode(int left, int right, int sum){
        this.start=left;
        this.end=right;
        this.sum=sum;
    }
    public SegTreeNode(int left, int right){
        this.start=left;
        this.end=right;
        this.sum=0;
    }

}
