package com.example.alg.listpck;

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


    //partial sum reverse 617 +295 = 912
    public ListNode addLists(ListNode l1, ListNode l2){
        final int len1 = l1.length();
        final int len2 = l2.length();

        //pad shorter list with zeros
        if(len1<len2){
            l1 = padList(l1, len2-len1);
        }else {
            l2 = padList(l2, len1-len2);
        }

        final PartialSum partialSum = addListsHelper(l1, l2);

        if(partialSum.carry!=0){
            partialSum.sum =  insertBefore(partialSum.sum, partialSum.carry);
            partialSum.carry=0;
        }

        return partialSum.sum;
    }

    PartialSum addListsHelper(ListNode l1, ListNode l2){
        if(l1==null && l2==null){
            return new PartialSum();
        }

        final PartialSum partialSum = addListsHelper(l1.next, l2.next);

        final int currentSum = partialSum.carry + l1.val + l2.val;

        final ListNode resultNode = insertBefore(partialSum.sum, currentSum % 10);

        partialSum.sum= resultNode;
        partialSum.carry=currentSum/10;

        return partialSum;
    }

    private ListNode padList(ListNode listNode, int padding) {
        ListNode head = listNode;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private ListNode insertBefore(ListNode head, int data) {
        final ListNode newHead = new ListNode(data);
        if(head!=null){
            newHead.next=head;
        }
        return newHead;
    }


    private static class PartialSum{

        public ListNode sum = null;
        public int carry = 0;

    }

}
