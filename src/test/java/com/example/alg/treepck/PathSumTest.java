package com.example.alg.treepck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class PathSumTest {
    @Test
    public void pathSum() throws Exception {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left=node1;
        root.right=node2;
        TreeNode node11 = new TreeNode(11);
        node1.left=node11;
        TreeNode node21 = new TreeNode(13);
        TreeNode node22 = new TreeNode(4);
        node2.left=node21;
        node2.right=node22;
        TreeNode node31 = new TreeNode(7);
        TreeNode node32 = new TreeNode(2);
        node11.left=node31;
        node11.right=node32;
        TreeNode node41 = new TreeNode(5);
        TreeNode node42 = new TreeNode(1);
        node22.left=node41;
        node22.right=node42;

        PathSum p = new PathSum();
        List<List<Integer>> paths = p.pathSum(root, 22);

        assertEquals(asList(
                asList(5,4,11,2),
                asList(5,8,4,5)
        ), paths);
    }

    @Test
    public void hasPathSum() throws Exception {

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left=node1;
        root.right=node2;
        TreeNode node11 = new TreeNode(11);
        node1.left=node11;
        TreeNode node21 = new TreeNode(13);
        TreeNode node22 = new TreeNode(4);
        node2.left=node21;
        node2.right=node22;
        TreeNode node31 = new TreeNode(7);
        TreeNode node32 = new TreeNode(2);
        node11.left=node31;
        node11.right=node32;
        TreeNode node42 = new TreeNode(1);
        node22.right=node42;

        PathSum p = new PathSum();
        boolean hasPathSum = p.hasPathSum(root, 22);
        assertTrue(hasPathSum);


    }

}