/*
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts. The intervals may be provided in any order.
*/



import  java.util.*;

class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
    }
}

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval interval1 = intervals.get(i);
            Interval interval2 = intervals.get(i + 1);

            if (Math.max(interval1.start, interval2.start) < Math.min(interval1.end, interval2.end)) {
                return false;
            }
        }

        return true;
    }
}
