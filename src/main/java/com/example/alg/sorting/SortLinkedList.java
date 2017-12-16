package com.example.alg.sorting;

import com.example.alg.listpck.ListNode;

public class SortLinkedList {

    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode current  = head;
        int count = 0;
        while (current!=null){
            count++;
            current=current.next;
        }

        final int middle = count / 2;

        ListNode left = head;
        ListNode right = null;

        ListNode node = head;
        int countNodes = 0;
        while (countNodes < middle){
            countNodes++;
            ListNode next = node.next;
            if(countNodes==middle){
                node.next =null;
                right=next;
            }
            node=next;
        }


        final ListNode listNodeLeft = sortList(left);
        final ListNode listNodeRight = sortList(right);

        return merge(listNodeLeft, listNodeRight);

    }

    private ListNode merge(ListNode left, ListNode right) {

        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (left!=null || right!=null){

            if(left==null){
                current.next = new ListNode(right.val);
                right=right.next;
                current=current.next;
                continue;
            }
            if(right==null){
                current.next=new ListNode(left.val);
                left=left.next;
                current=current.next;
                continue;
            }

            if(left.val==right.val){
                current.next=new ListNode(left.val);
                left=left.next;
                current=current.next;
                current.next=new ListNode(right.val);
                right=right.next;
                current=current.next;
                continue;
            }

            if(left.val<right.val){
                current.next=new ListNode(left.val);
                left=left.next;
                current=current.next;
            }else{
                current.next = new ListNode(right.val);
                right=right.next;
                current=current.next;
            }

        }

        return result.next;

    }
}
