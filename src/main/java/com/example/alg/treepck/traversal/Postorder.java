package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Postorder {

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
     * <p>
     * For example:
     * Given binary tree {1,#,2,3},
     * 1
     * \
     * 2
     * /
     * 3
     * return [3,2,1].
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.push(root);
        TreeNode temp = root;
        TreeNode prev = null;
        while (!nodesToVisit.isEmpty()) {

            TreeNode current = nodesToVisit.peek();

            if(prev == null || prev.left == current || prev.right==current){

                if(current.left!=null){
                    nodesToVisit.push(current.left);
                }else if(current.right!=null){
                    nodesToVisit.push(current.right);
                }else {
                    nodesToVisit.pop();
                    result.add(current.val);
                }

            }else if(current.left==prev){
                if(current.right!=null) {
                    nodesToVisit.push(current.right);
                }else {
                    nodesToVisit.pop();
                    result.add(current.val);
                }
            }else if(current.right==prev){
                nodesToVisit.pop();
                result.add(current.val);
            }

            prev = current;

        }

        return result;

    }
}
