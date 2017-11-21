package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;

import java.util.*;

public class RightSideView {
    /**
     * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

     For example:
     Given the following binary tree,
     1            <---
     /   \
     2     3         <---
     \     \
     5     4       <---
     You should return [1, 3, 4].
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> queueNodes = new ArrayDeque<>();
        queueNodes.offer(root);

        while (!queueNodes.isEmpty()){
            final int noNodesAtLevel = queueNodes.size();
            for(int i = 0; i< noNodesAtLevel; i++) {
                final TreeNode topNode = queueNodes.poll();

                if(i == 0){//first element at level
                    result.add(topNode.val);
                }
                if(topNode.right!=null){
                    queueNodes.offer(topNode.right);
                }
                if(topNode.left!=null){
                    queueNodes.offer(topNode.left);
                }
            }

        }
        return result;
    }
}
