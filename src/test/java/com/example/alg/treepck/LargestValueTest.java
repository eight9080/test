package com.example.alg.treepck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LargestValueTest {

    @Test
    public void largestValues() {

        final LargestValue l = new LargestValue();
        final List<Integer> maxValues = l.largestValues(tree());
        assertEquals(Arrays.asList(1,3,9), maxValues);

    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        root.left=node1;
        root.right=node2;
        TreeNode node11 = new TreeNode(5);
        TreeNode node12 = new TreeNode(3);
        node1.left=node11;
        node1.right=node12;
        TreeNode node21 = new TreeNode(9);
        node2.right=node21;
        return root;
    }
}