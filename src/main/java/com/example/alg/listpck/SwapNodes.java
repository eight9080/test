package com.example.alg.listpck;

public class SwapNodes {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.

     For example,
     Given 1->2->3->4, you should return the list as 2->1->4->3.

     Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

     */
    public ListNode swapPairs(ListNode head) {

        if(head==null){
            return null;
        }

        if(head.next==null){
            return head;
        }

        ListNode resultHead= new ListNode(0);

        ListNode currentResult = resultHead;

        ListNode current = head;

        while (current!=null && current.next!=null){

            ListNode next = current.next.next;

            currentResult.next=current.next;
            currentResult=currentResult.next;
            currentResult.next=current;
            currentResult=currentResult.next;

            current=next;

        }

        if(current!=null){
            currentResult.next=current;
            currentResult=currentResult.next;
        }

        currentResult.next=null;

        return resultHead.next;

    }
}
