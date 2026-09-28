/*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.
*/

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        HashMap<Integer, Integer> prefix_freq = new HashMap<>();
        int count = 0;

        for (int i = 0; i <= n; i++) {
            int prev_prefix = prefix[i] - k;

            if (prefix_freq.containsKey(prev_prefix)) {
                count += prefix_freq.get(prev_prefix);
            }

            prefix_freq.put(prefix[i], prefix_freq.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
    }
}