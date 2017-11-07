package com.example.alg.listpck;

public class Palindrome {

    /**
     * Given a singly linked list, determine if it is a palindrome.

     Follow up:
     Could you do it in O(n) time and O(1) space?
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        //find list center
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        slow.next = null; //end first part


        //reverse list
        ListNode n1 = middle;
        ListNode n2 = n1.next;

        while (n2 != null) {

            ListNode next = n2.next;
            n2.next = n1;

            n1 = n2;
            n2 = next;
        }

        middle.next = null;

        //compare the two list
        ListNode firstList = head;
        ListNode secondList = n1;

        while (firstList != null && secondList != null) {
            if (firstList.val != secondList.val) {
                return false;
            }

            firstList = firstList.next;
            secondList = secondList.next;

        }

        return true;
    }

}
