package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InorderTest {
    @Test
    public void inorderTraversal() throws Exception {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right=node1;
        node1.left=node2;

        Inorder p = new Inorder();
        List<Integer> result = p.inorderTraversal(root);

        assertEquals(Arrays.asList(1,3,2), result);
    }

}