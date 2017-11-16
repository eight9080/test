package com.example.alg.treepck;

import com.example.alg.listpck.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

     For example:
     Given the below binary tree and sum = 22,
     5
     / \
     4   8
     /   / \
     11  13  4
     /  \      \
     7    2      1
     return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null) return false;

        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> values = new LinkedList<>();

        nodes.add(root);
        values.add(root.val);

        while(!nodes.isEmpty()){

            TreeNode node = nodes.poll();
            Integer currentSum = values.poll();

            if(node.left==null && node.right==null && currentSum==sum){
                return true;
            }

            if(node.left!=null){
                nodes.offer(node.left);
                values.offer(currentSum+node.left.val);
            }
            if(node.right!=null){
                nodes.offer(node.right);
                values.offer(currentSum+node.right.val);
            }

        }
        return false;
    }

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

     For example:
     Given the below binary tree and sum = 22,
     5
     / \
     4   8
     /   / \
     11  13  4
     /  \    / \
     7    2  5   1
     return
     [
     [5,4,11,2],
     [5,8,4,5]
     ]
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        dfs(root, sum-root.val, result, l);
        return result;


    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> result, List<Integer> currentPath) {

        if(node.left==null && node.right==null && sum==0){
            result.add(new ArrayList<>(currentPath));
        }

        if(node.left!=null){
            currentPath.add(node.left.val);
            dfs(node.left, sum-node.left.val, result, currentPath);
            currentPath.remove(currentPath.size()-1);
        }

        if(node.right!=null){
            currentPath.add(node.right.val);
            dfs(node.right, sum-node.right.val, result, currentPath);
            currentPath.remove(currentPath.size()-1);
        }

    }
}
