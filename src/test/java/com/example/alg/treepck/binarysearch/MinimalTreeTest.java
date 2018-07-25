package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimalTreeTest {

    @Test
    public void createMinimalBST() {

        final int[] ints = {1, 2, 3, 4, 5};
        final MinimalTree minimalTree = new MinimalTree();
        final TreeNode minimalBST = minimalTree.createMinimalBST(ints);

        final TreeNode t1 = new TreeNode(1);
        final TreeNode t2 = new TreeNode(2);
        t1.right=t2;

        final TreeNode t4 = new TreeNode(4);
        final TreeNode t5 = new TreeNode(5);
        t4.right=t5;

        final TreeNode t3 = new TreeNode(3);
        t3.left=t1;
        t3.right=t4;

        assertEquals(t3, minimalBST);

    }
}