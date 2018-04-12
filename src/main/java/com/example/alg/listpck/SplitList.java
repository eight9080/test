package com.example.alg.listpck;

import java.util.List;

public class SplitList {

    /**
     * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

     The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

     The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

     Return a List of ListNode's representing the linked list parts that are formed.

     Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
     Example 1:
     Input:
     root = [1, 2, 3], k = 5
     Output: [[1],[2],[3],[],[]]
     Explanation:
     The input and each element of the output are ListNodes, not arrays.
     For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
     The first element output[0] has output[0].val = 1, output[0].next = null.
     The last element output[4] is null, but it's string representation as a ListNode is [].
     Example 2:
     Input:
     root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
     Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
     Explanation:
     The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root==null){
            return new ListNode[k];
        }

        int size=1;
        ListNode temp = root;
        while (temp.next!=null){
            size++;
            temp=temp.next;
        }

        final int fixedSize = size / k;
        int plusSize = size % k;

        ListNode[] result = new ListNode[k];

        temp = root;
        ListNode prev = null;

        int i = 0;
        while (temp!=null && i <k){
            result[i]=temp;

            int currentI = 0;
            int sizePart = fixedSize + (plusSize>0? 1:0);
            while (currentI<sizePart && temp!=null){
                prev=temp;
                temp=temp.next;
                currentI++;
            }
            prev.next=null;
            plusSize--;
            i++;
        }
        return result;
    }
}
