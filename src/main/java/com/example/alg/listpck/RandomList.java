package com.example.alg.listpck;

public class RandomList {
    /**
     * A linked list is given such that each node contains an additional random
     * pointer which could point to any node in the list or null.

     Return a deep copy of the list.


     */
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return null;

        RandomListNode p = head;

        // copy every node and insert to list
        while (p != null) {
            final RandomListNode copyNode = new RandomListNode(p.label);
            copyNode.next=p.next;
            p.next=copyNode;
            p=copyNode.next;
        }

        // copy random pointer
        p = head;
        while (p!=null){
            if(p.random!=null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        //extract copy list
        p = head;
        RandomListNode newHead = head.next;
        while (p!=null){
            RandomListNode temp = p.next;
            p.next = temp.next;
            if(temp.next!=null) {
                temp.next=temp.next.next;
            }
            p = p.next;
        }

        return newHead;
    }
}
//        while(p != null && p.next != null){
//            RandomListNode temp = p.next;
//            p.next = temp.next;
//            p = temp;
//        }