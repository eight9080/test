package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PreorderTest {
    @Test
    public void preorderTraversal() throws Exception {


        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right=node1;
        node1.left=node2;

        Preorder p = new Preorder();
        List<Integer> result = p.preorderTraversal(root);

        assertEquals(Arrays.asList(1,2,3), result);

    }

}