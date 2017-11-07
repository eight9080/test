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

        ListNode prev = null;// m-1
        ListNode first = new ListNode(0);// m node
        ListNode second = new ListNode(0);// n+1 node

        int position = 0;
        ListNode current = head;

        while (current!=null){
            position++;
            if(position==m-1){
                prev=current;
            }
            if(position==m){
                first.next=current;
            }
            if(position==n){
                second.next=current.next;
                current.next=null;
            }
            current=current.next;
        }

        if(first.next == null)
            return head;

        //reverse
        ListNode l1 = first.next;
        ListNode l2 = l1.next;
        l1.next=second.next;

        while (l2 != null){
            ListNode next = l2.next;
            l2.next=l1;

            l1=l2;
            l2=next;
        }

        if(prev!=null){
            prev.next=l1;
        }else {
            return l1;
        }

        return head;
    }


    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

     If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

     You may not alter the values in the nodes, only nodes itself may be changed.

     Only constant memory is allowed.

     For example,
     Given this linked list: 1->2->3->4->5

     For k = 2, you should return: 2->1->4->3->5

     For k = 3, you should return: 3->2->1->4->5
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }
}
