package com.example.alg.arraypkg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinIndexSum {

    /**
     * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

     You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

     Example 1:
     Input:
     ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
     Output: ["Shogun"]
     Explanation: The only restaurant they both like is "Shogun".
     Example 2:
     Input:
     ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     ["KFC", "Shogun", "Burger King"]
     Output: ["Shogun"]
     Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
     */
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> restaurantsByIds = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            restaurantsByIds.put(list1[i], -i);
        }

        int min = list1.length+list2.length+1;

        for (int i = 0; i < list2.length; i++) {
            final String restaurant = list2[i];
            if(restaurantsByIds.containsKey(restaurant)){
                final int sumIndex = restaurantsByIds.get(restaurant)*-1 + i;
                min = Math.min(min, sumIndex);
                restaurantsByIds.put(restaurant, sumIndex);
            }
        }

        int finalMin = min;
        final String[] result = restaurantsByIds.entrySet().stream()
                .filter(m -> m.getValue() == finalMin)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);


        return result;
    }
}
