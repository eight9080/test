package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TreePathsTest {
    @Test
    public void binaryTreePaths() throws Exception {
        final TreePaths t = new TreePaths();

        final List<String> paths = t.binaryTreePaths(tree());

        final List<String> expect = Arrays.asList("1->2->5", "1->3");
        assertEquals(expect, paths);


    }


    private TreeNode tree(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left=node11;
        root.right=node12;
        TreeNode node22 = new TreeNode(5);
        node11.right=node22;

        return root;
    }
}