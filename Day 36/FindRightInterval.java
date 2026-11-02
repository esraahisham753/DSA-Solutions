/*
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
*/

import java.util.*;

class Solution {
    class Interval {
        private int a;
        private int b;
        private int index;

        public Interval(int a, int b, int index) {
            this.a = a;
            this.b = b;
            this.index = index;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        // Convert to custom interval
        Interval[] myIntervals = new Interval[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            myIntervals[i] = new Interval(intervals[i][0], intervals[i][1], i);
        }

        // Rest work
        int[] right = new int[intervals.length];
        Arrays.fill(right, -1);
        Arrays.sort(myIntervals, (interval1, interval2) -> Integer.compare(interval1.a, interval2.a));
        
        for (int i = 0; i < intervals.length; i++) {
            // Start binary search
            int lo = i;
            int hi = intervals.length - 1;

            while (lo < hi) {
                int mid = lo + ((hi - lo) / 2);

                // check feasibility
                if (myIntervals[mid].a >= myIntervals[i].b) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            // check if the res is valid
            if (lo < intervals.length && myIntervals[lo].a >= myIntervals[i].b) {
                // update right entry
                right[myIntervals[i].index] = myIntervals[lo].index;
            }
        }

        return right;
    }
}