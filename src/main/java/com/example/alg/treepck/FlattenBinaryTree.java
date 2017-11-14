package com.example.alg.treepck;

import java.util.*;

public class FlattenBinaryTree {

    /**
     * Given a binary tree, flatten it to a linked list in-place.

     For example,
     Given

     1
     / \
     2   5
     / \   \
     3   4   6
     The flattened tree should look like:
     1
     \
     2
     \
     3
     \
     4
     \
     5
     \
     6
     */
    public void flatten(TreeNode root) {
        if(root==null)
            return;

        List<TreeNode> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node);

            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }

        for(int i = 0; i< result.size()-1; i++){

            TreeNode node = result.get(i);
            TreeNode right = result.get(i + 1);

            node.left=null;
            node.right=right;

        }
        result.get(result.size()-1).left=null;

    }

    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while(p != null || !stack.empty()){

            if(p.right != null){
                stack.push(p.right);
            }

            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }

            p = p.right;
        }
    }
}
