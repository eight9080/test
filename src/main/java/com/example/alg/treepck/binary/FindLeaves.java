package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeaves {
    /**
     * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

     Example:
     Given binary tree

     1
     / \
     2   3
     / \
     4   5
     Returns [4, 5, 3], [2], [1].
      */
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root==null){
            return null;
        }
        List<List<Integer>> all = new ArrayList<>();
        dfs(root, all);
        return all;
    }

    // traverse the tree bottom-up recursively
    public int dfs(TreeNode root, List<List<Integer>> all){
        if(root==null){
            return -1; // level -1 under the leaves
        }

        int left = dfs(root.left, all);
        int right = dfs(root.right, all);
        int level = Math.max(left, right) + 1; //leaves level + 1 for the current level

        if(all.size()<=level){
            all.add(new ArrayList<>());
        }

        all.get(level).add(root.val);
        return level;
    }
}
