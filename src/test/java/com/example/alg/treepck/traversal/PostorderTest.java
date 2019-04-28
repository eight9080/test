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

    @Test
    public void postorderTraversal2()  {

        final TreeNode root = tree(45, 25, 55);
        tree(root.left, 15, 35);
        treeLeft(root.left.left, 5);
        tree(root.left.right, 77, 88);

        Postorder p = new Postorder();
        List<Integer> result = p.postorderTraversal(root);

        assertEquals(Arrays.asList(5, 15, 77, 88, 35, 25, 55, 45), result);

    }

    private TreeNode tree(int rootValue, int left, int right){
        TreeNode root = new TreeNode(rootValue);
        TreeNode node1 = new TreeNode(left);
        TreeNode node2 = new TreeNode(right);
        root.left=node1;
        root.right=node2;
        return root;
    }

    private void tree(TreeNode root, int left, int right){
        TreeNode node1 = new TreeNode(left);
        root.left=node1;
        TreeNode node2 = new TreeNode(right);
        root.right=node2;
    }

    private void treeLeft(TreeNode root, int left){
        TreeNode node1 = new TreeNode(left);
        root.left=node1;
    }
}