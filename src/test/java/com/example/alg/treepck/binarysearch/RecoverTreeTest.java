package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecoverTreeTest {
    @Test
    public void recoverTree() throws Exception {

        final RecoverTree r = new RecoverTree();
        final TreeNode tree = tree();
        r.recoverTree(tree);

        assertEquals(expectTree(), tree);

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

        TreeNode node31 = new TreeNode(14);
        TreeNode node32 = new TreeNode(17);
        node12.left=node31;
        node12.right=node32;

        return root;
    }

    private TreeNode expectTree(){
        TreeNode root = new TreeNode(10);
        TreeNode node11 = new TreeNode(5);
        TreeNode node12 = new TreeNode(15);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(7);
        node11.right=node21;
        node11.right=node22;

        TreeNode node31 = new TreeNode(14);
        TreeNode node32 = new TreeNode(17);
        node12.left=node31;
        node12.right=node32;

        return root;
    }

    @Test
    public void recoverTree1() throws Exception {
        TreeNode root = new TreeNode(0);
        root.left=new TreeNode(1);

        TreeNode expectRoot = new TreeNode(1);
        expectRoot.left=new TreeNode(0);

        final RecoverTree r = new RecoverTree();
        r.recoverTree(root);

        assertEquals(expectRoot, root);

    }


}