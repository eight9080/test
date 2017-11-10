package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class BinaryTreeOrderTraversalTest {
    @Test
    public void levelOrderBottom() throws Exception {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left=node1;
        root.right=node2;
        TreeNode node3 = new TreeNode(15);
        node1.left=node3;
        TreeNode node4 = new TreeNode(7);
        node2.right=node4;

        BinaryTreeOrderTraversal b = new BinaryTreeOrderTraversal();
        List<List<Integer>> lists = b.levelOrderBottom(root);
        List<List<Integer>> expected = asList(asList(15, 7),  asList(9, 20), asList(3) );
        assertEquals(expected, lists);
    }

    @Test
    public void levelOrder() throws Exception {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left=node1;
        root.right=node2;
        TreeNode node3 = new TreeNode(15);
        node1.left=node3;
        TreeNode node4 = new TreeNode(7);
        node2.right=node4;

        BinaryTreeOrderTraversal b = new BinaryTreeOrderTraversal();
        List<List<Integer>> lists = b.levelOrder(root);
        List<List<Integer>> expected = asList(asList(3), asList(9, 20), asList(15, 7));
        assertEquals(expected, lists);

    }

}