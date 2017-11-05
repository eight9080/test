package com.example.alg.listpck;

public class IntersectionList {

    /**
     * Write a program to find the node at which the intersection of two singly
     * linked lists begins.


     For example, the following two linked lists:

     A:          a1 → a2
     ↘
     c1 → c2 → c3
     ↗
     B:     b1 → b2 → b3
     begin to intersect at node c1.


     Notes:

     If the two linked lists have no intersection at all, return null.
     The linked lists must retain their original structure after the function returns.
     You may assume there are no cycles anywhere in the entire linked structure.
     Your code should preferably run in O(n) time and use only O(1) memory.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null || headB==null){
            return null;
        }


        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        int diff = Math.abs(lengthA-lengthB);

        ListNode currentA = headA;
        ListNode currentB = headB;

        if(lengthA<lengthB){
            while (diff>0){
                currentB=currentB.next;
                diff--;
            }
        }else {
            while (diff>0){
                currentA=currentA.next;
                diff--;
            }
        }

        while (currentA!=null && currentB!=null){
            if(currentA==currentB){
                return currentA;
            }
            currentA=currentA.next;
            currentB=currentB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while(current!=null){
            length++;
            current=current.next;
        }
        return length;
    }
}
