package com.example.alg.listpck;

public class ReverseList {

    /**
     * Reverse a singly linked list.
     */
    public ListNode reverseList(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode l1 = head;
        ListNode l2 = head.next;
        head.next = null;

        while (l1!=null && l2!=null){
            ListNode next = l2.next;
            l2.next=l1;

            l1=l2;
            l2=next;
        }
        return l1;
    }
}
