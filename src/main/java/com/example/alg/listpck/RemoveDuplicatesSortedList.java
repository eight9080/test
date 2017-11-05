package com.example.alg.listpck;

public class RemoveDuplicatesSortedList {

    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.

     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.
     */
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode p = head;

        while(p!=null && p.next!=null){
            if(p.val==p.next.val){
                p.next=p.next.next;
            }else {
                p=p.next;
            }
        }

        return head;
    }

    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.

     For example,
     Given 1->2->3->3->4->4->5, return 1->2->5.
     Given 1->1->1->2->3, return 2->3.
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode p = newHead;

        while(p.next!=null && p.next.next!=null){
            if(p.next.val==p.next.next.val){
                int duplicateVal = p.next.val;
                while (p.next!=null && p.next.val==duplicateVal){
                    p.next=p.next.next;
                }

            }else {
                p = p.next;
            }
        }

        return newHead.next;

    }

}
