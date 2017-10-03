package com.example.alg.arraypkg;

import java.util.*;

public class ClosestLocations {


    public static List<List<Integer>> closestLocations(int totalCrates, List<List<Integer>> allLocations,
                                                       int truckCapacity) {
        if (allLocations == null || allLocations.isEmpty() || truckCapacity == 0) {
            return null;
        }

        Map<Double, List<Integer>> positionsByDistances = new HashMap<>();
        for (int i = 0; i < allLocations.size(); i++) {
            final List<Integer> location = allLocations.get(i);
            final double distance = calculateDistance(location);
            positionsByDistances.putIfAbsent(distance, new ArrayList<>());
            positionsByDistances.get(distance).add(i);
        }

        final ArrayList<Double> distances = new ArrayList<>(positionsByDistances.keySet());
        Collections.sort(distances);

        List<List<Integer>> result = new ArrayList<>();
        for (Double distance : distances) {
            if (truckCapacity > result.size()) {
                final List<Integer> positions = positionsByDistances.get(distance);
                for (Integer position : positions) {
                    if (truckCapacity > result.size()) {
                        result.add(allLocations.get(position));
                    }
                }
            }
        }

        return result;
    }

    private static double calculateDistance(List<Integer> location) {
        final Double sumSquares = location.stream().map(pos -> Math.pow(pos, 2))
                .reduce(0d, (a, b) -> a + b);
        return Math.sqrt(sumSquares);
    }
}
