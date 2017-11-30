package com.example.alg.heappck;

import com.example.alg.model.Interval;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeetingRoomsTest {
    @Test
    public void minMeetingRooms() throws Exception {
        final MeetingRooms m = new MeetingRooms();
        final Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        final int meetingRooms = m.minMeetingRooms(intervals);
        assertEquals(2, meetingRooms);
    }

    @Test
    public void canAttendMeetings() throws Exception {
        final MeetingRooms m = new MeetingRooms();
        final Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        final boolean b = m.canAttendMeetings(intervals);
        assertFalse(b);
    }

}