package com.example.alg.listpck;

import java.util.stream.IntStream;

public class NthToLast {

    ListNode nthToLast(ListNode head, int k){

        if(head==null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            if(p1==null){
                return null;
            }
            p1 = p1.next;
        }

        while (p1!=null){
            p1=p1.next;
            p2=p2.next;
        }

        return p2;
    }
}
