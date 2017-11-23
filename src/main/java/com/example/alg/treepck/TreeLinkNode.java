package com.example.alg.treepck;

import java.util.Objects;

public class TreeLinkNode {

    public int val;

    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeLinkNode that = (TreeLinkNode) o;
        return val == that.val &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right, next);
    }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val +
                ", left=" + (left!= null? String.valueOf(left.val): "-") +
                ", right=" + (right!= null? String.valueOf(right.val):"-") +
                ", next=" + (next!= null? String.valueOf(next.val):"-") +
                '}';
    }
}
