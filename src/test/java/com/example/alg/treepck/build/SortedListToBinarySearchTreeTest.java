package com.example.alg.treepck.build;

import com.example.alg.listpck.ListNode;
import com.example.alg.treepck.TreeNode;
import com.example.alg.treepck.traversal.Preorder;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortedListToBinarySearchTreeTest {
    @Test
    public void sortedListToBST() throws Exception {

        SortedListToBinarySearchTree s = new SortedListToBinarySearchTree();
        TreeNode treeNode = s.sortedListToBST(ListNode.createList(Arrays.asList(1,2,3,4,5)));

        System.out.println(Preorder.print(treeNode));
        System.out.println(Preorder.print(expect()));

        assertEquals(expect(), treeNode);

    }

    private TreeNode expect(){
        TreeNode root = new TreeNode(3);
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(4);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(2);
        node11.right=node21;

        TreeNode node32 = new TreeNode(5);
        node12.right=node32;

        return root;
    }

}