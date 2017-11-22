package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {
    @Test
    public void lowestCommonAncestor() throws Exception {

        final LowestCommonAncestor l = new LowestCommonAncestor();
        final TreeNode node1 = l.lowestCommonAncestor(tree(), new TreeNode(5), new TreeNode(1));
        assertEquals(3, node1.val);

        final TreeNode node2 = l.lowestCommonAncestor(tree(), new TreeNode(5), new TreeNode(4));
        assertEquals(5, node2.val);

    }

    @Test
    public void lowestCommonAncestor1() throws Exception {

        final LowestCommonAncestor l = new LowestCommonAncestor();
        final TreeNode node1 = l.lowestCommonAncestor(tree(), new TreeNode(5), new TreeNode(0));
        assertEquals(3, node1.val);

    }


    private TreeNode tree(){
        TreeNode root = new TreeNode(3);
        TreeNode node11 = new TreeNode(5);
        TreeNode node12 = new TreeNode(1);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(6);
        TreeNode node22 = new TreeNode(2);
        node11.right=node21;
        node11.right=node22;

        TreeNode node31 = new TreeNode(0);
        TreeNode node32 = new TreeNode(8);
        node12.left=node31;
        node12.right=node32;

        TreeNode node41 = new TreeNode(7);
        TreeNode node42 = new TreeNode(4);
        node22.left=node41;
        node22.right=node42;

        return root;
    }

}