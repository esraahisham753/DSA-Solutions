/*
    You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

    The length of the subarray is k, and
    All the elements of the subarray are distinct.
    Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

    A subarray is a contiguous non-empty sequence of elements within an array.
 */

import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0; 
        long maxSum = sum;

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }

        if (map.size() == k) {
            maxSum = sum;
        }

        for (int i = 1; i <= n - k; i++) {
            int prevFreq = map.get(nums[i - 1]) - 1;

            if (prevFreq == 0) {
                map.remove(nums[i - 1]);
            } else {
                map.put(nums[i - 1], prevFreq);
            }
            
            map.put(nums[i + k - 1], map.getOrDefault(nums[i + k - 1], 0) + 1);
            sum -= nums[i - 1];
            sum += nums[i + k - 1];

            if (map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}