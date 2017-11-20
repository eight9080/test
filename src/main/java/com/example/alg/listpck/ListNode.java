package com.example.alg.listpck;

import java.util.List;
import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

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

    public static String toStringList(ListNode head){
        ListNode temp = head;
        if(temp==null){
            return "";
        }
        StringBuilder text = new StringBuilder();
        text.append(temp.val);

        while(temp.next!=null){
            text.append("->").append(temp.next.val);
            temp = temp.next;
        }
        return text.toString();
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
