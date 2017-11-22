package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {
    @Test
    public void lowestCommonAncestor() throws Exception {

        final LowestCommonAncestor l = new LowestCommonAncestor();
        final TreeNode t1 = l.lowestCommonAncestor(tree(), new TreeNode(2), new TreeNode(8));
        assertEquals(6, t1.val);

        final TreeNode t2 = l.lowestCommonAncestor(tree(), new TreeNode(2), new TreeNode(4));
        assertEquals(2, t2.val);

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