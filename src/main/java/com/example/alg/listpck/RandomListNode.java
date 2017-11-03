package com.example.alg.listpck;

import java.util.Objects;

public class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int x) {
        label = x;
    }

    RandomListNode(int x, RandomListNode next) {
        label = x;
        this.next = next;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomListNode that = (RandomListNode) o;
        return label == that.label &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, next, random);
    }
}
