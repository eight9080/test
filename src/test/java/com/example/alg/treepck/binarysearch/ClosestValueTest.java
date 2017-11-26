package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClosestValueTest {
    @Test
    public void closestValue() throws Exception {

        final ClosestValue c = new ClosestValue();
        final int closest = c.closestValue(tree(), 1);
        assertEquals(2, closest);

    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(6);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(8);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(0);
        TreeNode node22 = new TreeNode(4);
        node11.right=node21;
        node11.right=node22;

        TreeNode node31 = new TreeNode(7);
        TreeNode node32 = new TreeNode(9);
        node12.left=node31;
        node12.right=node32;

        return root;
    }

}