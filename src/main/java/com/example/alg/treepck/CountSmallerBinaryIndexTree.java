package com.example.alg.treepck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerBinaryIndexTree {
    /**
     * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

     Example:

     Given nums = [5, 2, 6, 1]

     To the right of 5 there are 2 smaller elements (2 and 1).
     To the right of 2 there is only 1 smaller element (1).
     To the right of 6 there is 1 smaller element (1).
     To the right of 1 there is 0 smaller element.
     Return the array [2, 1, 1, 0].
     */
    public List<Integer> countSmaller(int[] nums) {
        if(nums==null || nums.length==0){
            return Collections.emptyList();
        }
        final int length = nums.length;
        final TreeNodeBST root = new TreeNodeBST(nums[length - 1]);

        List<Integer> result = new ArrayList<>();
        result.add(0);

        for (int i = length-2; i >=0 ; i--) {
            int count = addNode(root, nums[i]);
            result.add(count);
        }

        Collections.reverse(result);

        return result;
    }

    private int addNode(TreeNodeBST root, int num) {
        int count = 0;
        while (true){
            if(num<=root.value){
                root.count++;
                if(root.left!=null){
                    root=root.left;
                }else {
                    root.left = new TreeNodeBST(num);
                    break;
                }
            }else {
                count+=root.count;
                if(root.right!=null){
                    root = root.right;
                }else {
                    root.right= new TreeNodeBST(num);
                    break;
                }

            }
        }

        return count;
    }
}

class TreeNodeBST{
    TreeNodeBST left;
    TreeNodeBST right;
    int value;
    int count=1;

    public TreeNodeBST(int value) {
        this.value = value;
    }
}
