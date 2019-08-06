package com.example.alg.treepck.traversal;

import com.example.alg.treepck.TreeNode;

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


    /**
     * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
     *
     * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
     *
     * Example 1:
     * Input: Binary tree: [1,2,3,4]
     *        1
     *      /   \
     *     2     3
     *    /
     *   4
     *
     * Output: "1(2(4))(3)"
     *
     * Explanation: Originallay it needs to be "1(2(4)())(3()())",
     * but you need to omit all the unnecessary empty parenthesis pairs.
     * And it will be "1(2(4))(3)".
     * Example 2:
     * Input: Binary tree: [1,2,3,null,4]
     *        1
     *      /   \
     *     2     3
     *      \
     *       4
     *
     * Output: "1(2()(4))(3)"
     *
     * Explanation: Almost the same as the first example,
     * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
     */
    public String tree2str(TreeNode t) {
        //ROOT LEFT RIGHT

        //ROOT
        if(t==null){
            return "";
        }

        String str = "" + t.val;

        //LEFT
        final String left = tree2str(t.left);
        //RIGHT
        final String right = tree2str(t.right);

        final boolean emptyLeft = "".equals(left);
        final boolean emptyRight = "".equals(right);

        if( emptyLeft && emptyRight){
            return str;
        }

        if(emptyLeft){
            return str + "()("+right+")";
        }

        if(emptyRight){
            return str + "("+left+")";
        }

        return str +"("+ left+")("+right+")";

    }
}
