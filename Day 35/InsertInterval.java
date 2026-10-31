/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Two intervals are considered overlapping if they share at least one point.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.
*/

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean startMerge = false;
        boolean finishMerge = false;

        for (int[] interval: intervals) {
            if (startMerge && !finishMerge) {
                int[] lastMerged = res.get(res.size() - 1);

                if (isOverlap(lastMerged, interval)) {
                    lastMerged[1] = Math.max(lastMerged[1], interval[1]); 
                } else {
                    finishMerge = true;
                    res.add(new int[] {interval[0], interval[1]});
                }
            } else if (! finishMerge && newInterval[1] < interval[0]) {
                res.add(newInterval);
                res.add(new int[] {interval[0], interval[1]});
                finishMerge = true;
            } 
            else {
                res.add(new int[] {interval[0], interval[1]});
            }

            int[] lastMerged = res.get(res.size() - 1);

            if (! startMerge && isOverlap(lastMerged, newInterval)) {
                startMerge = true;
                lastMerged[0] = Math.min(lastMerged[0], newInterval[0]);
                lastMerged[1] = Math.max(lastMerged[1], newInterval[1]);
            }
        }

        if (! startMerge && !finishMerge) {
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][]);
    }

    private boolean isOverlap(int[] interval1, int[] interval2) {
        return Math.max(interval1[0], interval2[0]) <= Math.min(interval1[1], interval2[1]);
    }
}