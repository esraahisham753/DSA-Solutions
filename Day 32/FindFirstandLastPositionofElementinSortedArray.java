/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // find lower bound
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = l + ((r - l) / 2);

            if (nums[m] == target) {
                r = m;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (l == nums.length) {
            return new int[] {-1, -1};
        } else if (nums[l] != target) {
            return new int[] {-1, -1};
        }

        int lower = l;
        r = nums.length;

        while (l < r) {
            int m = l + ((r - l) / 2);

            if (target >= nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return new int[] {lower, l - 1};
    }
}