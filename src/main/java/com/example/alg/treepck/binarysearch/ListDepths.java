package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;

import java.util.*;

public class ListDepths {

    public List<List<TreeNode>> createLevelList(TreeNode node){

        if(node==null){
            return Collections.emptyList();
        }

        List<List<TreeNode>> result = new ArrayList<>();

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(node);

        while (!nodes.isEmpty()){

            final int size = nodes.size();
            final ArrayList<TreeNode> level =new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode current = nodes.remove();
                level.add(current);
                if(current.left!=null){
                    nodes.add(current.left);
                }
                if(current.right!=null){
                    nodes.add(current.right);
                }
            }
            if(!level.isEmpty()){
                result.add(level);
            }

        }
        return result;
    }

}
