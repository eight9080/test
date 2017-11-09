package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PostorderTest {
    @Test
    public void postorderTraversal() throws Exception {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right=node1;
        node1.left=node2;

        Postorder p = new Postorder();
        List<Integer> result = p.postorderTraversal(root);

        assertEquals(Arrays.asList(3,2,1), result);

    }

}