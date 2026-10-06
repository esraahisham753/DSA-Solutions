/*
    Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = 0;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            // Expand till valid
            sum += nums[right];

            if (sum < target) {
                continue;
            }

            // Shrink while valid
            while (left < right && (sum - nums[left]) >= target) {
                sum -= nums[left];
                left++;
            } 

            // Update answer
            if (minLen == 0) {
                minLen = right - left + 1;
            } else {
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        return minLen;
    }
}