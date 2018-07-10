package com.example.alg.listpck;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesUnsortedList {

    /**
     * Given a unsorted linked list, delete all duplicates such that each element appear only once.

     For example,
     Given 1->2->1->2, return 1->2.
     Given 1->3->1->2->3->3, return 1->3->2.
     */
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
            return head;

        Set<Integer> elements = new HashSet<>();
        elements.add(head.val);

        ListNode p = head;

        while(p!=null && p.next!=null){
            if(elements.contains(p.next.val)){
                p.next=p.next.next;
            }else {
                elements.add(p.next.val);
                p=p.next;
            }
        }

        return head;
    }

}
