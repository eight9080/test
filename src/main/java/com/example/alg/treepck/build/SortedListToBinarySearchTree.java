package com.example.alg.treepck.build;

import com.example.alg.listpck.ListNode;
import com.example.alg.treepck.TreeNode;

public class SortedListToBinarySearchTree {

    ListNode currentNode;

    /**
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    public TreeNode sortedListToBST(ListNode head) {

        if(head==null){
            return null;
        }

        this.currentNode = head;

        ListNode temp = head;
        int length = 0;
        while (temp!=null){
            length++;
            temp=temp.next;
        }

        return sortedListToBST(0, length-1);

    }

    private TreeNode sortedListToBST( int start, int end) {

        if(start>end){
            return null;
        }

        int middle = (start+end)/2;

        final TreeNode left = sortedListToBST( start, middle - 1);

        TreeNode root = new TreeNode(currentNode.val);
        currentNode=currentNode.next;


        final TreeNode right = sortedListToBST( middle + 1, end);

        root.left=left;
        root.right = right;

        return root;

    }
}
