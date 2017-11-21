package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RightSideViewTest {
    @Test
    public void rightSideView() throws Exception {

        final RightSideView r = new RightSideView();
        final List<Integer> rightSide = r.rightSideView(tree());
        assertEquals(Arrays.asList(1,3,4), rightSide);

    }

    private TreeNode tree(){
        TreeNode root = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3);
        root.left=node11;
        root.right=node12;
        TreeNode node22 = new TreeNode(5);
        node11.right=node22;

        TreeNode node32 = new TreeNode(4);
        node12.right=node32;

        return root;
    }

    @Test
    public void rightSideView1() throws Exception {

        final RightSideView r = new RightSideView();
        final List<Integer> rightSide = r.rightSideView(tree1());
        assertEquals(Arrays.asList(1,3,5), rightSide);

    }

    private TreeNode tree1(){
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