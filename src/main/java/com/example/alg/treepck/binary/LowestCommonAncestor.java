package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;

public class LowestCommonAncestor {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

     According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
     between two nodes v and w as the lowest node in T that has both v and w as descendants
     (where we allow a node to be a descendant of itself).”

     _______3______
     /              \
     ___5__          ___1__
     /      \        /      \
     6      _2       0       8
     /  \
     7   4
     For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
     Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }

        if(root.val==p.val || root.val==q.val){
//        if(root==p || root==q){
            return root;
        }

        final TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        final TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if(leftNode!=null && rightNode!=null){
            return root;
        }

        return leftNode!=null ? leftNode : rightNode;

    }

}
