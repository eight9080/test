package com.example.alg.listpck;

import java.util.Objects;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddNumbers {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode resultHead = new ListNode(0);
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode n3  = resultHead;

        while (n1 != null || n2 != null) {
            int result = carry;

            if(n1!=null) {
                result += n1.val;
                n1 = n1.next;
            }
            if(n2!=null) {
                result += n2.val;
                n2 = n2.next;
            }

            n3.next = new ListNode(result%10);
            n3 = n3.next;

            carry = result/10;
        }
        if(carry>0){
            n3.next=new ListNode(carry);
        }

        return resultHead.next;
    }
}
