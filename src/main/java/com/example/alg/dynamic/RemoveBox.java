package com.example.alg.dynamic;


import java.util.HashMap;
import java.util.Map;

public class RemoveBox {
    /**
     * Given a num­ber of boxes with dif­fer­ent col­ors rep­re­sented by dif­fer­ent pos­i­tive num­bers. You need to remove all the boxes in sev­eral rounds, each time you can choose con­tin­u­ous boxes with the same color (means with same num­bers, com­posed of k boxes, k >= 1), remove them and get k*k points.
     Write an algo­rithm to get the max­i­mum points by remov­ing all the boxes.
     1233211

     Remove 33 – Profit = 2*2 = 4, Remaining = 12211
     Remove 22 – Profit = 4 + 2*2 = 8, Remaining = 111
     Remove 11 - Profit = 3*3 + 8 = 17
     We will try to club iden­ti­cal num­bers so that when we will remove those together, will get the max­i­mum profit since if we are remov­ing x boxes then profit will be x*x.

     */
    public int removeBoxRecursiv(String input) {
        int profit = 0;

        if(input==null || input.length()==0){
            return 0;
        }

        if(input.length()==1){
            return 1;
        }

        int start = 0;
        int end = 0;

        while (start<input.length()){
            char c = input.charAt(start);
            int count = 0;
            while (end<input.length() && c == input.charAt(end)){
                count++;
                end++;
            }

            if(end>input.length()){
                profit = Math.max(profit, count*count);
            }else {
                String firstPart = input.substring(0, start);
                String lastPart = input.substring(end, input.length());
                profit = Math.max(profit, removeBoxRecursiv(firstPart+lastPart)+count*count);
            }
            start=end;
        }

        return profit;
    }

    //Dynamic programming
    public int removeBox(String input) {
        int profit = 0;

        if(input==null || input.length()==0){
            return 0;
        }

        if(input.length()==1){
            return 1;
        }
        Map<String, Integer> profitsByString = new HashMap<>();
       return removeBoxHelper(input, profitsByString);
    }

    private int removeBoxHelper(String input, Map<String, Integer> profitsByString) {
        int profit = 0;

        if(input==null || input.length()==0){
            return 0;
        }

        if(input.length()==1){
            return 1;
        }

        if(profitsByString.containsKey(input)){
            return profitsByString.get(input);
        }

        int start = 0;
        int end = 0;

        while (start<input.length()){
            char c = input.charAt(start);
            int count = 0;
            while (end<input.length() && c == input.charAt(end)){
                count++;
                end++;
            }

            if(end>input.length()){
                profit = Math.max(profit, count*count);
            }else {
                String firstPart = input.substring(0, start);
                String lastPart = input.substring(end, input.length());
                profit = Math.max(profit, removeBoxHelper(firstPart+lastPart, profitsByString)+count*count);
            }
            start=end;
        }
        profitsByString.put(input, profit);
        return profit;
    }

    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        int size = boxes.length;
        int[][][] dp = new int[size][size][size];

        return get(dp, boxes, 0, size-1, 1);
    }

    private int get(int[][][] dp, int[] boxes, int i, int j, int k) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            return k * k;
        } else if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        } else {
            int temp = get(dp, boxes, i + 1, j, 1) + k * k;

            for (int m = i + 1; m <= j; m++) {
                if (boxes[i] == boxes[m]) {
                    temp = Math.max(temp, get(dp, boxes, i + 1, m - 1, 1) + get(dp, boxes, m, j, k + 1));
                }
            }

            dp[i][j][k] = temp;
            return temp;
        }


    }


}
