package com.example.alg.treepck.binarysearch;

import com.example.alg.treepck.TreeNode;

public class MinimalTree {

    public TreeNode createMinimalBST(int[] array){

        return createMinimalBST(array, 0, array.length-1);

    }

    private TreeNode createMinimalBST(int[] array, int start, int end) {

        if(start>end ){
            return null;
        }

        final int middle = (start + end)/2;

        final TreeNode root = new TreeNode(array[middle]);

        root.left = createMinimalBST(array,start, middle-1);
        root.right = createMinimalBST(array, middle+1, end);

        return root;

    }


}
