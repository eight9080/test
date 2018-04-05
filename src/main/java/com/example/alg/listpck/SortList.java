package com.example.alg.listpck;

public class SortList {


    /**
     * Sort a linked list using insertion sort.
     */
    public ListNode insertionSortList(ListNode head) {

        if( head == null ){
            return null;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode current = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( current != null ){
            next = current.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < current.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            current.next = pre.next;
            pre.next = current;
            pre = helper;
            current = next;
        }

        return helper.next;

    }
}
