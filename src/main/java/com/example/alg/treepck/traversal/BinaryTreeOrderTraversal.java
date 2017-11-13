package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeOrderTraversal {

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> qLevel = new ArrayDeque<>();
        Deque<TreeNode> qChildren = new ArrayDeque<>();

        qLevel.add(root);

        List<Integer> levelElems = new ArrayList<>();
        while (!qLevel.isEmpty()){
            TreeNode node = qLevel.remove();
            levelElems.add(node.val);
            if(node.left!=null) {
                qChildren.add(node.left);
            }
            if(node.right!=null){
                qChildren.add(node.right);
            }
            //end level
            if(qLevel.isEmpty()){
                result.add(levelElems);
                levelElems = new ArrayList<>();
                qLevel.addAll(qChildren);
                qChildren.clear();
            }
        }

        return result;
    }

    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its bottom-up level order traversal as:
     [
     [15,7],
     [9,20],
     [3]
     ]
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> qLevel = new ArrayDeque<>();
        qLevel.offer(root);


        while (!qLevel.isEmpty()){
            int noElems =  qLevel.size();

            List<Integer> levelElems = new ArrayList<>();
            for(int i = 0; i< noElems; i++){
                TreeNode node = qLevel.poll();
                if(node.left!=null){
                    qLevel.offer(node.left);
                }
                if(node.right!=null){
                    qLevel.offer(node.right);
                }
                levelElems.add(node.val);
            }
            result.add(0, levelElems);
        }
        return result;
    }

    public static String print(TreeNode root){

        BinaryTreeOrderTraversal b = new BinaryTreeOrderTraversal();
        List<List<Integer>> lists = b.levelOrder(root);
        return lists.stream().flatMap(Collection::stream)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }


}
