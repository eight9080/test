package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckSubTreeTest {

    @Test
    public void containsSubtree() {
        final CheckSubTree c = new CheckSubTree();
        assertTrue(c.containsSubtree(tree(), subtree()));
    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(10);
        TreeNode node11 = new TreeNode(15);
        TreeNode node12 = new TreeNode(5);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(7);
        node11.right=node21;
        node11.right=node22;

        return root;
    }

    private TreeNode subtree(){
        TreeNode node11 = new TreeNode(15);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(7);
        node11.right=node21;
        node11.right=node22;

        return node11;
    }
}