package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Inorder {

    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.

     For example:
     Given binary tree [1,null,2,3],
     1
     \
     2
     /
     3
     return [1,3,2].
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> nodesToVisit = new ArrayDeque<>();

        TreeNode temp = root;
        while (temp!=null || !nodesToVisit.isEmpty()){

            if(temp!=null){
                nodesToVisit.push(temp);
                temp = temp.left;
            }else {
                TreeNode node = nodesToVisit.poll();
                result.add(node.val);
                temp = node.right;
            }

        }

        return result;

    }
}
