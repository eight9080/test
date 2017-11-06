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

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.

     For example: given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(m==n) return head;

        return null;
    }
}
