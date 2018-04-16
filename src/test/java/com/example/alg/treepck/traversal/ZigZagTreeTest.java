package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ZigZagTreeTest {

    @Test
    public void zigzagLevelOrder() {

        final ZigZagTree z = new ZigZagTree();
        final List<List<Integer>> lists = z.zigzagLevelOrder(tree());

        final List<List<Integer>> expect = Arrays.asList(Arrays.asList(3), Arrays.asList(20, 9),
                Arrays.asList(15, 7));
        assertEquals(expect, lists);
    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        root.left=node1;
        root.right=node2;
        TreeNode node3 = new TreeNode(15);
        TreeNode node11 = new TreeNode(7);
        node2.left=node3;
        node2.right=node11;

        return root;
    }

    @Test
    public void zigzagLevelOrder1() {

        final ZigZagTree z = new ZigZagTree();
        final List<List<Integer>> lists = z.zigzagLevelOrder(tree1());

        final List<List<Integer>> expect = Arrays.asList(Arrays.asList(1),
                Arrays.asList(3,2),
                Arrays.asList(4,5));
        assertEquals(expect, lists);
    }

    private TreeNode tree1(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left=node1;
        root.right=node2;
        TreeNode node3 = new TreeNode(4);
        node1.left=node3;
        TreeNode node11 = new TreeNode(5);
        node2.right=node11;
        ;
        return root;
    }
}