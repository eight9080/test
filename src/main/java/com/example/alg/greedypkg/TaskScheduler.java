package com.example.alg.greedypkg;

import java.util.*;

public class TaskScheduler {

    /**
     * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
     *
     * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
     *
     * You need to return the least number of intervals the CPU will take to finish all the given tasks.
     *
     * Example 1:
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1); // map key is TaskName, and value is number of times to be executed.
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (a,b) -> !a.getValue().equals(b.getValue()) ? b.getValue()-a.getValue(): a.getKey()-b.getKey()
        );
        queue.addAll(map.entrySet());

        int count = 0;

        while (!queue.isEmpty()){

            int interval = n+1;

            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();

            while (interval>0 && !queue.isEmpty()){
                final Map.Entry<Character, Integer> highestTask = queue.poll();
                highestTask.setValue(highestTask.getValue()-1);
                temp.add(highestTask);
                interval--;
                count++;
            }
            temp.stream().filter(t -> t.getValue()>0).forEach(queue::add);
            if(queue.isEmpty()){
                break;
            }
            count = count+interval;
        }
        return count;
    }

}
