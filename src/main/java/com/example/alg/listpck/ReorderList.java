package com.example.alg.listpck;

public class ReorderList {
    /**
     * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
     reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...

     For example, given {1,2,3,4}, reorder it to {1,4,2,3}.
     You must do this in-place without altering the nodes' values.

     Analysis

     This problem is not straightforward, because it requires "in-place" operations. That means we can only change their pointers, not creating a new list.

     Java Solution

     This problem can be solved by doing the following:

     Break list in the middle to two lists (use fast & slow pointers)
     Reverse the order of the second list
     Merge two list back together
     */

    public void reorderList(ListNode head) {
        if(head == null) return ;

        //find the middle
       ListNode slow = head;
       ListNode fast = slow.next;

       while (fast!=null && fast.next!=null){
           slow= slow.next;
           fast=fast.next.next;
       }

       //split the list in the middle
       ListNode half1 = head;
       ListNode half2 = slow.next;
       slow.next=null;

        //reverse last part
        ListNode reverseHalf2 = reverseList(half2);

        //merge the two list
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (half1!=null || reverseHalf2!=null){
            if(half1!=null){
                current.next = half1;
                current=current.next;
                half1=half1.next;
            }

            if(reverseHalf2!=null){
                current.next=reverseHalf2;
                current=current.next;
                reverseHalf2=reverseHalf2.next;
            }
        }

        head = result.next;

    }

    private ListNode reverseList(ListNode node) {
           ListNode prev = null;
           ListNode currentNode = node;
           ListNode next = null;

           while (currentNode!=null){
               next=currentNode.next;
               currentNode.next=prev;
               prev=currentNode;
               currentNode=next;
           }
        return prev;
    }
}
