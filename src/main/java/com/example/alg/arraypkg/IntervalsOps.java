package com.example.alg.arraypkg;

import com.example.alg.model.Interval;

import java.util.*;

public class IntervalsOps {

    /**
     * Given a collection of intervals, merge all overlapping intervals.

     For example,
     Given [1,3],[2,6],[8,10],[15,18],
     return [1,6],[8,10],[15,18].

     Analysis

     The key to solve this problem is defining a Comparator first to sort the arraylist of Intevals.
     */
    public static List<Interval> merge(List<Interval> intervals){
        if(intervals==null || intervals.isEmpty()){
            return Collections.emptyList();
        }

        intervals.sort(Comparator.comparing(Interval::getStart).thenComparing(Interval::getEnd));

        final ArrayList<Interval> resultIntervals = new ArrayList<>();
        Interval preInterval = intervals.get(0);
        for (Interval interval: intervals) {
            if(interval.getStart()>preInterval.getEnd()){
                resultIntervals.add(preInterval);
                preInterval = interval;
            }else{
                preInterval = new Interval(preInterval.getStart(), Math.max(preInterval.getEnd(), interval.getEnd()));
            }
        }
        resultIntervals.add(preInterval);

        return resultIntervals;
    }

    /**
     * Example 1:
     Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

     Example 2:
     Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

     This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */
    public static ArrayList<Interval> insert(List<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<>();

        for(Interval interval: intervals){
            if(interval.getEnd() < newInterval.getStart()){
                result.add(interval);
            }else if(interval.getStart() > newInterval.getEnd()){
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.getEnd() >= newInterval.getStart() || interval.getStart() <= newInterval.getEnd()){
                newInterval = new Interval(Math.min(interval.getStart(), newInterval.getStart()), Math.max(newInterval.getEnd(), interval.getEnd()));
            }
        }

        result.add(newInterval);

        return result;
    }

    public static Interval interval(int start, int end){
        return new Interval(start, end);
    }

}
