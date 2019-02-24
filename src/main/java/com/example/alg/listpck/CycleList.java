package com.example.alg.listpck;

public class CycleList {

    /**
     * Given a linked list, determine if it has a cycle in it.

     Analysis

     If we have 2 pointers - fast and slow.
     It is guaranteed that the fast one will meet the slow one if there exists a circle.
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return true;
            }

        }

        return false;
    }

    /**
     * 142
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
     * If pos is -1, then there is no cycle in the linked list.
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                ListNode slow2 = head;
                while (slow!=slow2){
                    slow=slow.next;
                    slow2=slow2.next;
                }
                return slow;
            }
        }

        return null;

    }
}
