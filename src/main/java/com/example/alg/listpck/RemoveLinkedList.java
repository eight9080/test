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
}
