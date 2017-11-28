package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class FindLeavesTest {
    @Test
    public void findLeaves() throws Exception {
        final FindLeaves f = new FindLeaves();
        final List<List<Integer>> leaves = f.findLeaves(tree());
        final List<List<Integer>> expectList = asList(asList(4, 5, 3), asList(2), asList(1));
        assertEquals(expectList, leaves);
    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left=node11;
        root.right=node12;
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        node11.left=node21;
        node11.right=node22;

        return root;
    }

}