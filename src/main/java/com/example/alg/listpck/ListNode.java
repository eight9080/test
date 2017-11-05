package com.example.alg.listpck;

import java.util.List;
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static ListNode createList(List<Integer> list){
        final ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        for(Integer value : list){
            current.next = new ListNode(value);
            current=current.next;
        }
        return fakeHead.next;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + (next!= null? String.valueOf(next.val): "-") +
                '}';
    }
}
