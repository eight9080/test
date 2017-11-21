package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Deque;

import static org.junit.Assert.*;

public class BSTIteratorTest {

    @Test
    public void next() throws Exception {

        final BSTIterator bstIterator = new BSTIterator(tree());

        assertTrue(bstIterator.hasNext());
        assertEquals(1, bstIterator.next());

    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(8);
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(10);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(6);
        node11.left=node21;
        node11.right=node22;

        TreeNode node32 = new TreeNode(14);
        node12.right=node32;
        TreeNode node41 = new TreeNode(13);
        node32.left=node41;

        return root;
    }

}