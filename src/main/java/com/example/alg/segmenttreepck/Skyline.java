package com.example.alg.segmenttreepck;

import java.util.*;

public class Skyline {

    /**
     * A city's skyline is the outer contour of the silhouette formed by
     * all the buildings in that city when viewed from a distance.
     * Now suppose you are given the locations and height of
     * all the buildings as shown on a cityscape photo (Figure A),
     * write a program to output the skyline formed by
     * these buildings collectively (Figure B).
     * <p>
     * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
     * where Li and Ri are the x coordinates of the left and right edge of the ith building,
     * respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX,
     * 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
     * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface
     * at height 0.
     * <p>
     * For instance, the dimensions of all buildings in Figure A are recorded as:
     * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
     * <p>
     * The output is a list of "key points" (red dots in Figure B) in the format of
     * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
     * A key point is the left endpoint of a horizontal line segment.
     * Note that the last key point, where the rightmost building ends,
     * is merely used to mark the termination of the skyline, and always has zero height.
     * Also, the ground in between any two adjacent buildings should be considered part of the skyline
     * contour.
     * <p>
     * For instance, the skyline in Figure B should be represented as:
     * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
     */
    public List<int[]> getSkyline(int[][] buildings) {

        if (buildings == null || buildings.length == 0
                || buildings[0].length == 0) {
            return new ArrayList<>();
        }

        // add left and right edges
        List<Edge> edges = new ArrayList<>();

        for (int[] building : buildings) {

            final int xStart = building[0];
            final int xEnd = building[1];
            final int height = building[2];
            edges.add(new Edge(xStart, height, true));
            edges.add(new Edge(xEnd, height, false));

        }

        //sort the edges
        edges.sort((o1, o2) -> {
            if (o1.x != o2.x) {
                return Integer.compare(o1.x, o2.x);
            }
            if (o1.isStart && o2.isStart) {
                return Integer.compare(o2.height, o1.height);
            }
            if (!o1.isStart && !o2.isStart) {
                return Integer.compare(o1.height, o2.height);
            }
            return o1.isStart ? -1 : 1;
        });

        edges.forEach(System.out::println);

        List<int[]> result = new ArrayList<>();

        PriorityQueue<Integer> heights = new PriorityQueue<>(5,
                Collections.reverseOrder());

        for (Edge edge : edges) {

            if (edge.isStart) {
                if (heights.isEmpty() || heights.peek() < edge.height) {
                    result.add(new int[]{edge.x, edge.height});
                }
                heights.add(edge.height);
                continue;
            }

            //end edge
            heights.remove(edge.height);
            if (heights.isEmpty()) {//end square
                result.add(new int[]{edge.x, 0});
            } else {
                if (heights.peek() < edge.height) {//return to a smaller height
                    result.add(new int[]{edge.x, heights.peek()});
                }
            }

        }

        return result;
    }
}
