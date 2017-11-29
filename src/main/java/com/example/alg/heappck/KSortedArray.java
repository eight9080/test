package com.example.alg.heappck;

import java.util.PriorityQueue;

public class KSortedArray {
    /**
     * Given m arrays, the minimum elements of all arrays can form a heap. It takes O(log(m))
     * to insert an element to the heap and it takes O(1) to delete the minimum element.
     */
    public static int[] mergeKSortedArray(int[][] arr) {

        PriorityQueue<ArrayContainer> queue = new PriorityQueue<>();
        int total = 0;

        //add arrays to queue
        for(int i = 0; i<arr.length; i++){
            queue.add(new ArrayContainer(arr[i], 0));
            total+=arr[i].length;
        }

        int index = 0;
        int[] result = new int[total];

        while (!queue.isEmpty()){
            final ArrayContainer c = queue.poll();
            result[index++]=c.arr[c.index];
            if(c.index<c.arr.length-1){
                queue.add(new ArrayContainer(c.arr,
                        c.index+1));
            }
        }

        return result;
    }
}
