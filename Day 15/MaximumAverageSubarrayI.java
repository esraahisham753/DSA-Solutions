/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        int n = nums.length;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        for (int i = 1; i <= n - k; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            maxSum = Math.max(maxSum, sum);    
        }

        return maxSum / k;
    }
}