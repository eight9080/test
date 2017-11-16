package com.example.alg.treepck.build;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeInorderPostorderTest {


    @Test
    public void buildTree() throws Exception {


        TreeInorderPostorder t = new TreeInorderPostorder();
        TreeNode treeNode = t.buildTree(new int[]{4, 2, 5, 1, 6, 7, 3, 8},
                new int[]{4, 5, 2, 6, 7, 8, 3, 1});

        assertEquals(expect(), treeNode);

    }

    private TreeNode expect(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        node11.left=node21;
        node11.right=node22;

        TreeNode node31 = new TreeNode(7);
        TreeNode node32 = new TreeNode(8);
        node12.left=node31;
        node12.right=node32;
        TreeNode node41 = new TreeNode(6);
        node31.left=node41;

        return root;
    }

}