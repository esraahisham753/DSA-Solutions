/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
*/

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // sort intervals
        Comparator<int[]> customComp = (a, b) -> {
            return Integer.compare(a[0], b[0]);
        };

        Arrays.sort(intervals, customComp);
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(new int[] {interval[0], interval[1]});
            } else {
                int[] lastMerged = merged.get(merged.size() - 1);
                lastMerged[1] = Math.max(lastMerged[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}