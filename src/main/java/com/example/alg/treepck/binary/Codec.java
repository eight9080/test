package com.example.alg.treepck.binary;

import com.example.alg.treepck.TreeNode;

import java.util.LinkedList;

public class Codec {
    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

     Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

     For example, you may serialize the following tree

     1
     / \
     2   3
        / \
       4   5
     as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null){
            return "";
        }

        StringBuilder sb = new StringBuilder("");

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            final TreeNode node = queue.poll();

            if(node!=null){
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }else {
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null || data.length()==0)
            return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));


        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i=1;
        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            if(node==null){
                continue;
            }

            final String left = arr[i++];
            if(!"null".equals(left)){
                node.left = new TreeNode(Integer.valueOf(left));
                queue.add(node.left);
            }

            final String right = arr[i++];
            if(!"null".equals(right)){
                node.right = new TreeNode(Integer.valueOf(right));
                queue.add(node.right);
            }

        }

        return root;
    }
}
