package com.example.alg.listpck;

public class RemoveLinkedList {

    /**
     * Remove all elements from a linked list of integers that have value val.

     Example
     Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     Return: 1 --> 2 --> 3 --> 4 --> 5
     */
    public ListNode removeElements(ListNode head, int val) {

        if(head==null){
            return null;
        }

        ListNode result = new ListNode(0);

        ListNode currentResult = result;

        ListNode current = head;
        while (current!=null){
            if(current.val!=val){
                currentResult.next=current;
                currentResult=currentResult.next;
            }
            current=current.next;
        }

        //end result list
        currentResult.next=null;

        return result.next;
    }

    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

     Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

     */
    public void deleteNode(ListNode node) {
        if(node==null || node.next==null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;

    }

    /**
     * Given a linked list, remove the nth node from the end of list and return its head.

     For example, given linked list 1->2->3->4->5 and n = 2, the result is 1->2->3->5.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        int count = 0;
        while (fast!=null && count<n){
            count++;
            fast=fast.next;
        }

        if(fast==null){
            head=head.next;
            return head;
        }

        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        //remove elem
        slow.next=slow.next.next;

        return head;

    }
}
