package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePaths {
    /**
     * iven a binary tree, return all root-to-leaf paths.

     For example, given the following binary tree:

     1
     /   \
     2     3
     \
     5
     All root-to-leaf paths are:

     ["1->2->5", "1->3"]
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return Collections.emptyList();
        }

        List<String> allPaths = new ArrayList<>();
        dfs(root, ""+root.val, allPaths);

        return allPaths;
    }

    public void dfs(TreeNode node, String path,  List<String> allPaths){
        if(node==null){
            return;
        }

        if(node.left==null && node.right==null){
            allPaths.add(path);
            return;
        }

        if(node.left!=null) {
            dfs(node.left, path + "->" + node.left.val, allPaths);
        }
        if(node.right!=null) {
            dfs(node.right, path + "->" + node.right.val, allPaths);
        }
    }

}
