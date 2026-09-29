/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
*/

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i <= n; i++) {
            if (! map.containsKey(prefix[i])) {
                map.put(prefix[i], i);
            } else {
                maxLen = Math.max(maxLen, i - map.get(prefix[i]));
            }
        }

        return maxLen;
    }
}