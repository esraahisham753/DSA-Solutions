/*
You are given an array of integers nums and an integer limit.

Return the size of the longest non-empty subarray such that the absolute difference between every pair of elements in this subarray is less than or equal to limit.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> monInc = new ArrayDeque<>();
        Deque<Integer> monDec = new ArrayDeque<>();
        int maxLen = 1;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            // Expand
            while (! monInc.isEmpty() && nums[i] <= nums[monInc.peekLast()]) {
                monInc.pollLast();
            }

            monInc.addLast(i);

            while (! monDec.isEmpty() && nums[i] >= nums[monDec.peekLast()]) {
                monDec.pollLast();
            }

            monDec.addLast(i);
            
            int diff = nums[monDec.peekFirst()] - nums[monInc.peekFirst()];

            // Shrink

            while (diff > limit) {
                left++;

                while (! monInc.isEmpty() && monInc.peekFirst() < left) {
                    monInc.pollFirst();
                }

                while (! monDec.isEmpty() && monDec.peekFirst() < left) {
                    monDec.pollFirst();
                }

                diff = nums[monDec.peekFirst()] - nums[monInc.peekFirst()];
            }

            // window is valid
            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }
}