package com.example.alg.heappck;

import com.example.alg.model.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings. For example,
     * Given [[0, 30],[5, 10],[15, 20]], return false.
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(Interval::getStart));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].getEnd() > intervals[i + 1].getStart()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
     * find the minimum number of conference rooms required.
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(Interval::getStart));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0].getEnd());
        int noRooms = 1;

        for (int i = 1; i < intervals.length; i++) {
            final int newStart = intervals[i].getStart();
            final Integer lastEnd = queue.peek();

            if (lastEnd > newStart) {
                noRooms++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i].getEnd());
        }

        return noRooms;
    }
}
