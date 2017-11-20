package com.example.alg.treepck;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    /**
     * Given a binary tree, find its minimum depth.

     The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


     */
    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> counts = new LinkedList<>();

        nodes.add(root);
        counts.add(1);

        while (!nodes.isEmpty()){
            final TreeNode node = nodes.poll();
            final Integer count = counts.poll();

            if(node.left==null && node.right==null){
                return count;
            }

            if(node.left!=null){
                nodes.offer(node.left);
                counts.offer(count+1);
            }

            if(node.right!=null){
                nodes.offer(node.right);
                counts.offer(count+1);
            }
        }

        return 0;
    }
}
