package com.example.alg.listpck;

public class RotateList {

    /**
     * Given a list, rotate the list to the right by k places, where k is non-negative.


     Example:

     Given 1->2->3->4->5->NULL and k = 2,

     return 4->5->1->2->3->NULL.
     */
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null){
            return null;
        }

        ListNode current = head;

        int size = 1;
        while (current.next!=null){
            size++;
            current=current.next;
        }

        //circular
        current.next=head;

        ListNode last = head;
        final int first = size - k % size;
        for (int i = first; i >1 ; i--) {
            last=last.next;
        }

        ListNode newHead = last.next;
        last.next=null;

        return newHead;

    }

}
