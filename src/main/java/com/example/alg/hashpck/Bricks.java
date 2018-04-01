package com.example.alg.hashpck;

import java.util.*;

public class Bricks {

    /**
     * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

     The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

     If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

     You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

     Example:
     Input:
     [[1,2,2,1],
     [3,1,2],
     [1,3,2],
     [2,4],
     [3,1,2],
     [1,3,1,1]]
     Output: 2
     */
    public int leastBricks(List<List<Integer>> wall) {

        List<List<Integer>> leftEdges = new ArrayList<>();

        for (List<Integer> list: wall) {
            int leftEdge = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {
                leftEdge = leftEdge+list.get(i);
                temp.add(leftEdge);
            }
            leftEdges.add(temp);
        }
        Map<Integer, Integer> edgesByRows =
                new HashMap<>();

        for (int i = 0; i < leftEdges.size(); i++) {
            final  int rowIndex = i;
            final List<Integer> row = leftEdges.get(i);
            row.forEach(column -> edgesByRows.compute(column, (k, v) -> (v==null?0:v)+1));
        }

        final Optional<Map.Entry<Integer, Integer>> max = edgesByRows.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        if(!max.isPresent()){
            return wall.size();
        }

        return wall.size()-max.get().getValue();

    }
}
