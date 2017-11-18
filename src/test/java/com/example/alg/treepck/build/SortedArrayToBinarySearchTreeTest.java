package com.example.alg.treepck.build;

import com.example.alg.treepck.TreeNode;
import com.example.alg.treepck.traversal.Preorder;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayToBinarySearchTreeTest {

    @Test
    public void sortedArrayToBST() throws Exception {

        SortedArrayToBinarySearchTree s = new SortedArrayToBinarySearchTree();
        TreeNode treeNode = s.sortedArrayToBST(new int[]{1, 2, 3, 4, 5});


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