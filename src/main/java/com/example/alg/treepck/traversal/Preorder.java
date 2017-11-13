package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Preorder {


    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.

     For example:
     Given binary tree [1,null,2,3],
     1
     \
     2
     /
     3
     return [1,2,3].
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(root);

        while (!nodesToVisit.isEmpty()){
            TreeNode node = nodesToVisit.poll();

            result.add(node.val);

            if(node.right!=null){
                nodesToVisit.push(node.right);
            }

            if(node.left!=null){
                nodesToVisit.push(node.left);
            }

        }

        return result;

    }

    public static String print(TreeNode root){
        Preorder preorder = new Preorder();
        List<Integer> nodes = preorder.preorderTraversal(root);
        return nodes.toString();

    }
}
