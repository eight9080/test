package com.example.alg.listpck;

public class PartitionList {


    /**
     * Given a linked list and a value x, partition it such that
     * all nodes less than x come before nodes greater than or equal to x.

     You should preserve the original relative order of the nodes in each of the two partitions.

     For example,
     Given 1->4->3->2->5->2 and x = 3,
     return 1->2->2->4->3->5.
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode headList1 = new ListNode(0);
        ListNode headList2 = new ListNode(0);

        ListNode currentNode = head;

        ListNode currentList1 = headList1;
        ListNode currentList2 = headList2;

        while (currentNode!=null){

            if(currentNode.val<x){
                currentList1.next = currentNode;
                currentList1 = currentList1.next;
            }else {
                currentList2.next = currentNode;
                currentList2 = currentList2.next;
            }

            currentNode = currentNode.next;
        }
        //end second list
        currentList2.next=null;
        //join 2 list
        currentList1.next=headList2.next;

        return headList1.next;
    }
}
