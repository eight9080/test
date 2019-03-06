package com.example.alg.listpck;

public class SortList {


    /**
     * Sort a linked list using insertion sort.
     */
    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode current = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while (current != null) {
            next = current.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < current.val) {
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

    /**
     * Given a linked list of size N consisting of 0s, 1s and 2s.
     * The task os to sort this linked list such that all zeroes segregate
     * to headside, 2s at the end and 1s in the mid of 0s and 2s.
     */
    ListNode linkSort(ListNode head) {

        ListNode helper = new ListNode(0);
        ListNode helperOne = new ListNode(0);
        ListNode helperTwo = new ListNode(0);

        ListNode current = head;
        ListNode pre = helper;
        ListNode preOne = helperOne;
        ListNode preTwo = helperTwo;

        while (current != null) {

            if (current.val == 0) {
                pre.next = current;
                pre = pre.next;
            }
            if (current.val == 1) {
                preOne.next = current;
                preOne = preOne.next;
            }
            if (current.val == 2) {
                preTwo.next = current;
                preTwo = preTwo.next;
            }
            current = current.next;

        }

        pre.next=helperOne.next!=null ? helperOne.next : helperTwo.next;
        preOne.next=helperTwo.next;
        preTwo.next=null;

        return helper.next;

    }
}
